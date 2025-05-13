package com.nurdinaffandidev.optionals;

import java.util.Objects;
import java.util.Optional;

public class Computer {
    // Attributes
    String model;
    Motherboard motherboard;

    // Constructor
    public Computer(String model) {
        this.model = model;
    }

    public Computer(String model, Motherboard motherboard) {
        this.model = model;
        this.motherboard = motherboard;
    }

    // Getter Setter
    /* Code might throw null pointer exception without optionals. */
    public Motherboard getMotherboard() {
        return motherboard;
    }

    /* Improved getter with Optional */
    public Optional<Motherboard> getOptionalMotherboard() {
        return Optional.ofNullable(motherboard);
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Methods
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(model, computer.model) && Objects.equals(motherboard, computer.motherboard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, motherboard);
    }
}
