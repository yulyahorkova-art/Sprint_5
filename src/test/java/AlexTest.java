package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    @Mock
    private Feline felineMock;

    @Test
    void constructor_shouldPassMaleToSuper() {
        Alex alex = new Alex(felineMock);
        assertTrue(alex.doesHaveMane()); // самец -> грива есть
    }

    @Test
    void getFriends_shouldReturnExpectedList() {
        Alex alex = new Alex(felineMock);
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    void getPlaceOfLiving_shouldReturnZoo() {
        Alex alex = new Alex(felineMock);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void getKittens_shouldReturnZero() {
        Alex alex = new Alex(felineMock);
        assertEquals(0, alex.getKittens());
    }

    @Test
    void getFood_shouldDelegateToFeline() throws Exception {
        List<String> expected = List.of("Мясо");
        when(felineMock.getFood("Хищник")).thenReturn(expected);

        Alex alex = new Alex(felineMock);
        List<String> actual = alex.getFood();

        assertEquals(expected, actual);
        verify(felineMock, times(1)).getFood("Хищник");
    }
}