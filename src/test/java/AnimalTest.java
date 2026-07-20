package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    void getFamily_shouldReturnCorrectString() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test
    void getFood_unknownKind_throwsException() {
        Exception exception = assertThrows(Exception.class,
                () -> animal.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }

    @Test
    void getFood_nullKind_throwsException() {
        Exception exception = assertThrows(Exception.class,
                () -> animal.getFood(null));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}