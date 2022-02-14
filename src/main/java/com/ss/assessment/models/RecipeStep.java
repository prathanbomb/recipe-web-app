package com.ss.assessment.models;

import org.springframework.lang.Nullable;

public class RecipeStep {

    private Long id;
    private Integer stepNumber;
    private String instruction;
    private Long ingredientId;
    private Long measurementUnitId;
    private Double measurementQty;

    public RecipeStep(@Nullable Long id, Integer stepNumber, String instruction, Long ingredientId, Long measurementUnitId, Double measurementQty) {
        this.id = id;
        this.stepNumber = stepNumber;
        this.instruction = instruction;
        this.ingredientId = ingredientId;
        this.measurementUnitId = measurementUnitId;
        this.measurementQty = measurementQty;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getMeasurementUnitId() {
        return measurementUnitId;
    }

    public void setMeasurementUnitId(Long measurementUnitId) {
        this.measurementUnitId = measurementUnitId;
    }

    public Double getMeasurementQty() {
        return measurementQty;
    }

    public void setMeasurementQty(Double measurementQty) {
        this.measurementQty = measurementQty;
    }
}
