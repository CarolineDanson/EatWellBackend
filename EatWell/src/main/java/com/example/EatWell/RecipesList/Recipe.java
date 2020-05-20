package com.example.EatWell.RecipesList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipeTitle;
    private String ingredients;
    //Can add @NotBlank to make variable required.

    public Recipe() {}

    public Recipe(String recipeTitle, String ingredients) {
        this.recipeTitle = recipeTitle;
        this.ingredients = ingredients;
    }

    public Recipe(Long id, String recipeTitle, String ingredients) {
        this.id = id;
        this.recipeTitle = recipeTitle;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
