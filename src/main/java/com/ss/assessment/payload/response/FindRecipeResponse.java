package com.ss.assessment.payload.response;

import com.ss.assessment.models.Recipe;

import java.util.List;

public class FindRecipeResponse {

    private List<Recipe> recipeList;

    public FindRecipeResponse(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

}
