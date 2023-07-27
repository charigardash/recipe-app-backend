package com.example.food.recipe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "default.mongo")
@NoArgsConstructor
@Data
public class MongoDbConfigProperties {
    String uri;
    String database;
    Long connectionMaxIdleTimeMs = 10000L;
    Long connectionMaxLifeTimeMs = 20000L;
    Integer poolMaxSize = 30;
    Integer poolMinSize = 10;
}
