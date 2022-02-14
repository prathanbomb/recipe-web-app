package com.ss.assessment.controllers;

import com.ss.assessment.models.Category;
import com.ss.assessment.models.Image;
import com.ss.assessment.models.Recipe;
import com.ss.assessment.models.RecipeStep;
import com.ss.assessment.models.entity.CategoryEntity;
import com.ss.assessment.models.entity.ImageEntity;
import com.ss.assessment.models.entity.RecipeEntity;
import com.ss.assessment.models.entity.RecipeStepEntity;
import com.ss.assessment.payload.request.CreateRecipeRequest;
import com.ss.assessment.payload.request.DeleteRecipeRequest;
import com.ss.assessment.payload.response.FindRecipeResponse;
import com.ss.assessment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    MeasurementUnitRepository measurementUnitRepository;

    @Autowired
    RecipeStepRepository recipeStepRepository;

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/categories")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll().stream().map(categoryEntity -> new Category(categoryEntity.getId(), categoryEntity.getCategoryName())).collect(Collectors.toList());
        return ResponseEntity.ok().body(categoryList);
    }

    @PostMapping("/recipes/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createRecipe(@Valid @RequestBody CreateRecipeRequest request) {

        List<CategoryEntity> categoryEntityList = categoryRepository.findAllById(request.getCategoryIdList());
        RecipeEntity recipeEntity = new RecipeEntity(new HashSet<>(categoryEntityList), request.getRecipeName());
        recipeRepository.save(recipeEntity);

        List<RecipeStepEntity> recipeStepEntityList = request.getRecipeSteps().stream().map(recipeStep -> new RecipeStepEntity(
                recipeStep.getStepNumber(),
                recipeEntity,
                measurementUnitRepository.getById(recipeStep.getMeasurementUnitId()),
                recipeStep.getMeasurementQty(),
                ingredientRepository.getById(recipeStep.getIngredientId()),
                recipeStep.getInstruction()
        )).collect(Collectors.toList());
        recipeStepRepository.saveAll(recipeStepEntityList);

        List<ImageEntity> imageEntityList = request.getImageList().stream().map(image -> new ImageEntity(
                recipeEntity,
                image.getName()
        )).collect(Collectors.toList());
        imageRepository.saveAll(imageEntityList);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/recipes/category")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getRecipeByCategory(@Valid @RequestParam(value = "id") long id) {
        List<Recipe> recipeList = new ArrayList<>();
        recipeRepository.findRecipeEntitiesByCategoriesContaining(categoryRepository.getById(id)).forEach(recipeEntity -> {
            recipeList.add(newRecipe(recipeEntity));
        });
        FindRecipeResponse response = new FindRecipeResponse(recipeList);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/recipes")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getRecipeById(@Valid @RequestParam(value = "id") long id) {
        RecipeEntity recipeEntity = recipeRepository.getById(id);
        return ResponseEntity.ok().body(newRecipe(recipeEntity));
    }

    private Recipe newRecipe(RecipeEntity recipeEntity) {
        return new Recipe(
                recipeEntity.getId(),
                recipeEntity.getRecipeName(),
                recipeEntity.getCategories().stream().map(categoryEntity -> new Category(
                        categoryEntity.getId(),
                        categoryEntity.getCategoryName()
                )).collect(Collectors.toList()),
                recipeStepRepository.findRecipeStepEntitiesByRecipe(recipeEntity).stream().map(recipeStepEntity -> new RecipeStep(
                        recipeStepEntity.getId(),
                        recipeStepEntity.getStepNumber(),
                        recipeStepEntity.getInstruction(),
                        recipeStepEntity.getIngredientEntity().getId(),
                        recipeStepEntity.getMeasurementUnitEntity().getId(),
                        recipeStepEntity.getMeasurementQty()
                )).collect(Collectors.toList()),
                imageRepository.findImageEntitiesByRecipe(recipeEntity).stream().map(imageEntity -> new Image(
                        imageEntity.getId(),
                        imageEntity.getImageName()
                )).collect(Collectors.toList())
        );
    }

    @PostMapping("/recipes/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteRecipe(@Valid @RequestBody DeleteRecipeRequest request) {
        recipeRepository.deleteAllById(request.getRecipeIdList());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ingredients/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllIngredients() {
        return ResponseEntity.ok(ingredientRepository.findAll());
    }

    @GetMapping("/units/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllMeasurementUnits() {
        return ResponseEntity.ok(measurementUnitRepository.findAll());
    }

}
