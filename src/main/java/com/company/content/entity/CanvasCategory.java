package com.company.content.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;


public enum CanvasCategory implements EnumClass<String> {

    LAC("LACQUERED"),
    MAT("MATTE"),
    SAT("SATIN");

    private final String name;

    CanvasCategory(String name) {
        this.name = name;
    }

    @Override
    public @NotNull String getId() {
        return name;
    }

    @Nullable
    public static CanvasCategory fromId(String name) {
        for (CanvasCategory at : CanvasCategory.values()) {
            if (at.getId().equals(name)) {
                return at;
            }
        }
        return null;
    }
}
