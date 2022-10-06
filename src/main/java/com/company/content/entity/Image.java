package com.company.content.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "CONTENT_IMAGE",
       indexes = {@Index(name = "IDX_CONTENT_IMAGE_NOMENCLATURE", columnList = "NOMENCLATURE_ID")})
@Entity(name = "content_Image")
public class Image {

    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FILE_TYPE")
    private String fileType;

    @Column(name = "SIZE_")
    private String size;

    @Column(name = "DATA_")
    private byte[] data;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "NOMENCLATURE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nomenclature nomenclature;

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
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

    @InstanceName
    @DependsOnProperties({"name", "fileType", "size"})
    public String getInstanceName() {
        return String.format("%s.%s [%s]", name, fileType, size);
    }
}
