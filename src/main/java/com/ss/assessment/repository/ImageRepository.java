package com.ss.assessment.repository;

import com.ss.assessment.models.entity.ImageEntity;
import com.ss.assessment.models.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    @Query("SELECT t FROM ImageEntity t WHERE t.recipeEntity = ?1")
    List<ImageEntity> findImageEntitiesByRecipe(RecipeEntity recipe);
}