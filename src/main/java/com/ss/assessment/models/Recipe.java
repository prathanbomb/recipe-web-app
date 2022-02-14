package com.ss.assessment.models;

import java.util.List;

public class Recipe {

    private Long id;
    private String name;
    private List<Category> categoryList;
    private List<RecipeStep> recipeStepList;
    private List<Image> imageList;

    public Recipe(Long id, String name, List<Category> categoryList, List<RecipeStep> recipeStepList, List<Image> imageList) {
        this.id = id;
        this.name = name;
        this.categoryList = categoryList;
        this.recipeStepList = recipeStepList;
        this.imageList = imageList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<RecipeStep> getRecipeStepList() {
        return recipeStepList;
    }

    public void setRecipeStepList(List<RecipeStep> recipeStepList) {
        this.recipeStepList = recipeStepList;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

}
