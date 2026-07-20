package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionParameterizedTest {

    @Mock
    private Feline felineMock;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void constructor_shouldSetHasManeCorrectly(String sex, boolean expectedHasMane) {
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}