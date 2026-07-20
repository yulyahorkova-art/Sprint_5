package com.example;

import java.util.List;

public class Lion {
    private final boolean hasMane;
    private final Feline feline;

    public Lion(String sex, Feline feline) {
        if (feline == null) {
            throw new IllegalArgumentException("Feline не может быть null");
        }

        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new IllegalArgumentException("Используйте допустимые значения пола животного: Самец или Самка");
        }
        this.feline = feline;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}


