package com.app.food.recipe.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Ingredient implements Serializable {
    
    private String name;

    private String quantity;

    private String unit;
    
}
