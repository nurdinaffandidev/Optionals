package com.nurdinaffandidev.optionals;

import java.util.Optional;

public class MainDemo {
    static void runHello(Optional<String> name) {
        System.out.println("Functional programming: ");
        // Functional programming
        String result = name.map(inputName -> {
            return "Hi " + inputName + "!";
        }).orElse("Hello!");

        System.out.println(result);
        System.out.println("If-Else: ");
        // if-else
        if (name.isPresent()) {
            System.out.println("Hi " + name.get() + "!");
        } else {
            System.out.println("Hello!");
        }
    }

    static void printOptional(Optional<String> inputOptional) {
        System.out.println("1. w/o orElse(): Hello " + inputOptional);
        System.out.println("2. with orElse(): Hello " + inputOptional.orElse("stranger!"));
        System.out.print("3. get(): ");
        if (inputOptional.isPresent()) {
            System.out.println("Hello " + inputOptional.get());
        } else {
            System.out.println("Hello stranger!");
        }
    }

    public static void main( String[] args ) {
        System.out.println("Optionals example 1:");
        runHello(Optional.of("Joe"));
        runHello(Optional.ofNullable(null));
// ====================================================================

        System.out.println("\nOptionals example 2:");
        String trainee = "Sandy";
        String traineeNull = null;

        // If we don't expect trainee to ever be null
        Optional<String> optionalTrainee = Optional.of(trainee);

        // If we expect some null values, we can use the ofNullable() method
        Optional<String> optionalTraineeNullable = Optional.ofNullable(trainee);
        Optional<String> optionalEmpty = Optional.empty();

        System.out.println("trainee: " + trainee);
        System.out.println("traineeNull: " + traineeNull);
        System.out.println("optionalTrainee: " + optionalTrainee);
        System.out.println("optionalTraineeNullable: " + optionalTraineeNullable);
        System.out.println("optionalEmpty: " + optionalEmpty);

        System.out.println();
        System.out.println("optionalTrainee:");
        printOptional(optionalTrainee);

        System.out.println("\noptionalTraineeNullable:");
        printOptional(optionalTraineeNullable);

        System.out.println("\noptionalEmpty:");
        printOptional(optionalEmpty);

    }
}
