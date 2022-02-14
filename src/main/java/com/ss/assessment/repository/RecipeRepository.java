package com.ss.assessment.repository;

import com.ss.assessment.models.entity.CategoryEntity;
import com.ss.assessment.models.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    List<RecipeEntity> findRecipeEntitiesByCategoriesContaining(CategoryEntity categoryEntity);
}