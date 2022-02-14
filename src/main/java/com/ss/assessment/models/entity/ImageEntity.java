package com.ss.assessment.models.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RecipeEntity recipeEntity;

    @Column(name = "image_name")
    private String imageName;

    public ImageEntity(RecipeEntity recipeEntity, String imageName) {
        this.recipeEntity = recipeEntity;
        this.imageName = imageName;
    }

    public ImageEntity() {

    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public RecipeEntity getRecipe() {
        return recipeEntity;
    }

    public void setRecipe(RecipeEntity recipeEntity) {
        this.recipeEntity = recipeEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}