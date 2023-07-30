package com.app.food.recipe.databaseEntity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.app.food.recipe.entity.BaseEntity;
import com.app.food.recipe.entity.RecipeIngredient;
import com.app.food.recipe.entity.RecipeInstruction;
import com.app.food.recipe.entity.RecipeUserFeedBack;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "recipe")
@Data
@EqualsAndHashCode(callSuper = false)
public class Recipe extends BaseEntity {
    @Id
    private String recipeId;

    @Field(name = "writer")
    private String userId;

    @Field(name="recipe_title")
    private String recipeTitle;

    @Field(name = "recipe_description")
    private String description;

    @Field(name = "recipe_prepration_time")
    private long preprationTime;

    @Field(name = "recipe_cooking_time")
    private long cookingsTime;

    @Field(name = "recipe_image")
    private byte[] image;

    @Field(name = "recipe_ingredients")
    private RecipeIngredient recipeIngredients;

    @Field(name = "recipe_instructions")
    private RecipeInstruction instruction;

    @Field(name = "recipe_users_feedback")
    private RecipeUserFeedBack recipeRatings;

}
