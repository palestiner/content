package com.company.content.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "CONTENT_CATEGORY")
@Entity(name = "content_Category")
public class Category {

    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private UUID id;

    @InstanceName
    @NotNull(message = "{msg://com.company.content.entity/Category.name.validation.NotNull}")
    @Column(name = "NAME", nullable = false)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
