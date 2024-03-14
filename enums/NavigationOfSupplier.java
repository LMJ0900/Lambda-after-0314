package com.turing.api.enums;

import java.util.Scanner;
import java.util.function.Supplier;

public enum NavigationOfSupplier {
    ;
    private final String name;
    private final Supplier<String>supplier;

    NavigationOfSupplier(String name, Supplier<String> supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    public static void selectMain(Scanner sc) {
    }

}
