package com.ss.assessment.payload.request;

import java.util.Set;

public class DeleteRecipeRequest {

    Set<Long> recipeIdList;

    public Set<Long> getRecipeIdList() {
        return recipeIdList;
    }

    public void setRecipeIdList(Set<Long> recipeIdList) {
        this.recipeIdList = recipeIdList;
    }

}
