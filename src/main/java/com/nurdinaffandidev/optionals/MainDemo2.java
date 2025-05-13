package com.nurdinaffandidev.optionals;

import java.util.function.Supplier;

public class MainDemo2 {
    public static void main(String[] args) {

        Computer myComputer = new Computer("HP");

        MemoryChip memoryChip2 = new MemoryChip("memoryChip2");
        Motherboard motherboard2 = new Motherboard("motherboard2", memoryChip2);
        Computer myComputer2 = new Computer("HPv2", motherboard2);

        /* Code might throw null pointer exception without optionals. */
//        myComputer.getMotherboard().getMemoryChip().accessData();

        // Method: .ifPresent()
        System.out.println(" // Method: .ifPresent()");
        myComputer.getOptionalMotherboard()
                .ifPresent(motherboard -> {
                    motherboard.getMemoryChip().accessData();
                });

        myComputer2.getOptionalMotherboard()
                .ifPresent(motherboard -> motherboard.getMemoryChip().accessData());

        // Method: .ifPresent().OrElse()
        System.out.println("\n // Method: .ifPresent()");
        myComputer.getOptionalMotherboard()
                .orElse(new Motherboard("defaulted motherboard"))
                .getOptionalMemoryChip()
                .orElse(new MemoryChip("defaulted memory chip"))
                .accessData();

        myComputer2.getOptionalMotherboard()
                .orElse(new Motherboard("defaulted motherboard"))
                .getOptionalMemoryChip()
                .orElse(new MemoryChip("defaulted memory chip"))
                .accessData();

        // Method: .orElseThrow()
        System.out.println("\n// Method: .orElseThrow()");
        Supplier<MotherboardException> motherboardExceptionSupplier = () -> new MotherboardException("no motherboard present");

        try {
            myComputer2.getOptionalMotherboard()
                    .orElseThrow(motherboardExceptionSupplier)
                    .getMemoryChip()
                    .accessData();
        } catch (MotherboardException e) {
            e.printStackTrace();
        }

        try {
            myComputer.getOptionalMotherboard()
                    .orElseThrow(motherboardExceptionSupplier)
                    .getMemoryChip()
                    .accessData();
        } catch (MotherboardException e) {
            e.printStackTrace();
        }
    }
}
