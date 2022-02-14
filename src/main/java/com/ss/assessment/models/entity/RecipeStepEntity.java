package com.ss.assessment.models.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "recipe_steps")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class RecipeStepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "step_number")
    private Integer stepNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RecipeEntity recipeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MeasurementUnitEntity measurementUnitEntity;

    @Column(name = "measurement_qty")
    private Double measurementQty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private IngredientEntity ingredientEntity;

    @Column(name = "instruction")
    private String instruction;

    public RecipeStepEntity(Integer stepNumber, RecipeEntity recipeEntity, MeasurementUnitEntity measurementUnitEntity, Double measurementQty, IngredientEntity ingredientEntity, String instruction) {
        this.stepNumber = stepNumber;
        this.recipeEntity = recipeEntity;
        this.measurementUnitEntity = measurementUnitEntity;
        this.measurementQty = measurementQty;
        this.ingredientEntity = ingredientEntity;
        this.instruction = instruction;
    }

    public RecipeStepEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public RecipeEntity getRecipeEntity() {
        return recipeEntity;
    }

    public void setRecipeEntity(RecipeEntity recipeEntity) {
        this.recipeEntity = recipeEntity;
    }

    public MeasurementUnitEntity getMeasurementUnitEntity() {
        return measurementUnitEntity;
    }

    public void setMeasurementUnitEntity(MeasurementUnitEntity measurementUnitEntity) {
        this.measurementUnitEntity = measurementUnitEntity;
    }

    public Double getMeasurementQty() {
        return measurementQty;
    }

    public void setMeasurementQty(Double measurementQty) {
        this.measurementQty = measurementQty;
    }

    public IngredientEntity getIngredientEntity() {
        return ingredientEntity;
    }

    public void setIngredientEntity(IngredientEntity ingredientEntity) {
        this.ingredientEntity = ingredientEntity;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}