package com.company.content.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CONTENT_NOMENCLATURE",
       indexes = {@Index(name = "IDX_CONTENT_NOMENCLATURE_CATEGORY", columnList = "CATEGORY_ID")})
@Entity(name = "content_Nomenclature")
public class Nomenclature {

    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private UUID id;

    @InstanceName
    @Column(name = "DESCRIPTION", nullable = false)
    @NotNull(message = "{msg://com.company.content.entity/Nomenclature.description.validation.NotNull}")
    private String description;

    @Composition
    @JoinColumn(name = "CATEGORY_ID")
    @OneToOne(fetch = FetchType.LAZY)
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @NotNull(message = "{msg://com.company.content.entity/Nomenclature.category.validation.NotNull}")
    private Category category;

    @Column(name = "PRICE")
    private String price;

    @OneToMany(mappedBy = "nomenclature", fetch = FetchType.LAZY)
    @Size(message = "{msg://com.company.content.entity/Nomenclature.images.validation.Size}", min = 0, max = 2)
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
