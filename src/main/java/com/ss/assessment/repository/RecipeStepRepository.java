package com.ss.assessment.repository;

import com.ss.assessment.models.entity.RecipeEntity;
import com.ss.assessment.models.entity.RecipeStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeStepRepository extends JpaRepository<RecipeStepEntity, Long> {
    @Query("SELECT t FROM RecipeStepEntity t WHERE t.recipeEntity = ?1")
    List<RecipeStepEntity> findRecipeStepEntitiesByRecipe(RecipeEntity recipeEntity);
}
