package com.nurdinaffandidev.optionals;

import java.util.Objects;

public class MemoryChip {
    // Attributes
    String model;

    // Constructor
    public MemoryChip(String model) {
        this.model = model;
    }

    // Getter Setter
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Methods
    public void accessData() {
        System.out.println("(accessData) Memory Chip : " + model);
    }

    @Override
    public String toString() {
        return "MemoryChip{" +
                "model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemoryChip that = (MemoryChip) o;
        return Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(model);
    }
}
