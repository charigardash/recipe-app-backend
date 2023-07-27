package com.example.food.recipe.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RecipeUserFeedBack implements Serializable{
    private List<UserFeedBack> ratings;
}
