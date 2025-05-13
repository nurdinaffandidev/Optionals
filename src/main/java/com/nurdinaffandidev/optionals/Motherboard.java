package com.nurdinaffandidev.optionals;

import java.util.Objects;
import java.util.Optional;

public class Motherboard {
    // Attributes
    String model;
    MemoryChip memoryChip;

    // Constructor
    public Motherboard(String model) {
        this.model = model;
    }

    public Motherboard(String model, MemoryChip memoryChip) {
        this.model = model;
        this.memoryChip = memoryChip;
    }

    // Getter Setter
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /* Code might throw null pointer exception without optionals. */
    public MemoryChip getMemoryChip() {
        return memoryChip;
    }

    /* Improved getter with Optional */
    public Optional<MemoryChip> getOptionalMemoryChip() {
        return Optional.ofNullable(memoryChip) ;
    }

    public void setMemoryChip(MemoryChip memoryChip) {
        this.memoryChip = memoryChip;
    }

    // Methods
    @Override
    public String toString() {
        return "Motherboard{" +
                "model='" + model + '\'' +
                ", memoryChip=" + memoryChip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Motherboard that = (Motherboard) o;
        return Objects.equals(model, that.model) && Objects.equals(memoryChip, that.memoryChip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, memoryChip);
    }
}
