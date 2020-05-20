package com.example.EatWell.Exceptions;

public class RecipeNotFoundException extends Exception {

    private long recipe_id;
    public RecipeNotFoundException(long recipe_id) {
        super(String.format("Recipe is not found with id : '%s'", recipe_id));
    }

}
