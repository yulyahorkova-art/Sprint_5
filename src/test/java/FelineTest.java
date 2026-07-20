package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void eatMeat_shouldReturnPredatorFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void getFamily_shouldReturnCats() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittens_noArg_shouldReturnOne() {
        assertEquals(1, feline.getKittens());
    }
}