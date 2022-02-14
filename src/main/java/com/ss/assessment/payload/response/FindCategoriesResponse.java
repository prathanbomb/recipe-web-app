package com.ss.assessment.payload.response;

import com.ss.assessment.models.entity.CategoryEntity;

import java.util.List;

public class FindCategoriesResponse {

    private List<CategoryEntity> categories;

    public FindCategoriesResponse(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

}
