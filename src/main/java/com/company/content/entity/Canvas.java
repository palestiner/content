package com.company.content.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "CONTENT_CANVAS")
@Entity(name = "content_Canvas")
public class Canvas {

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @NotEmpty(message = "{msg://com.company.content.entity/Canvas.name.validation.NotBlank}")
    @NotBlank(message = "{msg://com.company.content.entity/Canvas.name.validation.NotBlank}")
    @NotNull(message = "{msg://com.company.content.entity/Canvas.name.validation.NotNull}")
    @InstanceName
    @Column(name = "NAME")
    private String name;

    @NotNull(message = "{msg://com.company.content.entity/Canvas.width.validation.NotNull}")
    @Column(name = "WIDTH")
    private Integer width;

    @NotNull(message = "{msg://com.company.content.entity/Canvas.category.validation.NotNull}")
    @Column(name = "CATEGORY")
    private String category;

    @NotNull(message = "{msg://com.company.content.entity/Canvas.color.validation.NotNull}")
    @Column(name = "COLOR")
    private String color;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CanvasCategory getCategory() {
        return category == null ? null : CanvasCategory.fromId(category);
    }

    public void setCategory(CanvasCategory category) {
        this.category = category == null ? null : category.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
