package com.ss.assessment.payload.request;

import com.ss.assessment.models.Image;
import com.ss.assessment.models.RecipeStep;

import java.util.List;
import java.util.Set;

public class CreateRecipeRequest {

    private String recipeName;
    private Set<Long> categoryIdList;
    private List<RecipeStep> recipeSteps;
    private List<Image> imageList;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Set<Long> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(Set<Long> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }

    public List<RecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
