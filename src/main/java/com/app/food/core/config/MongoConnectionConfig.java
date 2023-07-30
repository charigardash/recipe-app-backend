package com.app.food.core.config;

import java.util.concurrent.TimeUnit;

import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import io.micrometer.common.util.StringUtils;

@Configuration
@EnableConfigurationProperties(MongoDbConfigProperties.class)
@EnableMongoRepositories(basePackages = "com.example.*")
public class MongoConnectionConfig {

    @Autowired
    private MongoDbConfigProperties mongoDbConfigProperties;

    @Bean
    @Primary
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), mongoDbConfigProperties.getDatabase());
    }

    private MongoClient mongo() {
        if (StringUtils.isBlank(mongoDbConfigProperties.getUri())) {
            System.exit(1);
        }
        final ConnectionString connectionString = new ConnectionString(mongoDbConfigProperties.getUri());

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .uuidRepresentation(UuidRepresentation.JAVA_LEGACY)
                .applyConnectionString(connectionString)
                .applyToConnectionPoolSettings(builder -> builder.maxConnectionIdleTime(mongoDbConfigProperties.getConnectionMaxIdleTimeMs(), TimeUnit.MILLISECONDS)
                        .maxConnectionLifeTime(mongoDbConfigProperties.getConnectionMaxLifeTimeMs(), TimeUnit.MILLISECONDS)
                        .maxSize(mongoDbConfigProperties.getPoolMaxSize())
                        .minSize(mongoDbConfigProperties.getPoolMinSize())
                        .build())
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}
