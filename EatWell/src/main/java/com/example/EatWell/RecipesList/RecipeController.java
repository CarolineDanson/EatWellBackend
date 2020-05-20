package com.example.EatWell.RecipesList;

import com.example.EatWell.Exceptions.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    //Get all recipes
    @GetMapping("/recipe")
    public List<Recipe> getAllRecipes() {

        //model.addAttribute(new Recipe());
        return (List<Recipe>) recipeRepository.findAll();
    }

    //Create new recipe
    @PostMapping("/recipe")
    public Recipe createRecipe(@RequestBody Recipe recipe) {

        //model.addAttribute("recipe", new Recipe(ingredients, recipeTitle));
        return recipeRepository.save(recipe);
    }

    // Get a single recipe
    @GetMapping("/recipe/{id}")
    public Recipe getRecipeById(@PathVariable(value = "id") Long recipeId) throws RecipeNotFoundException {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));
    }


    // Update a recipe
    @PutMapping("/recipe/{id}")
    public Recipe updateRecipe(@PathVariable(value = "id") Long recipeId,
                               @Valid @RequestBody Recipe recipeDetails) throws RecipeNotFoundException {

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));

        recipe.setRecipeTitle(recipeDetails.getRecipeTitle());
        recipe.setIngredients(recipeDetails.getIngredients());

        Recipe updatedRecipe = recipeRepository.save(recipe);

        return updatedRecipe;
    }

    // Delete a recipe
    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable(value = "id") Long recipeId) throws RecipeNotFoundException {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));

        recipeRepository.delete(recipe);

        return ResponseEntity.ok().build();
    }

}