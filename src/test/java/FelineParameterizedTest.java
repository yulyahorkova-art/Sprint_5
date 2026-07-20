package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class FelineParameterizedTest {

    private final Feline feline = new Feline();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "5, 5",
            "10, 10"
    })
    void getKittens_withArg_shouldReturnGivenCount(int input, int expected) {
        assertEquals(expected, feline.getKittens(input));
    }
}