package com.company.content.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Texture implements EnumClass<String> {

    LAC("LACQUERED"),
    MAT("MATTE"),
    SAT("SATIN");

    private final String name;

    Texture(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return name;
    }

    @Nullable
    public static Texture fromId(String name) {
        for (Texture at : Texture.values()) {
            if (at.getId().equals(name)) {
                return at;
            }
        }
        return null;
    }
}
