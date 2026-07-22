import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    void constructor_withInvalidSex_shouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lion("Invalid", felineMock));
    }

    @Test
    void constructor_withNullFeline_shouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lion("Самец", null));
    }

    @Test
    void getKittens_shouldDelegateToFeline() {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    void getFood_shouldCallFelineGetFoodWithPredator() throws Exception {
        List<String> expected = List.of("Рыба", "Птицы");
        when(felineMock.getFood("Хищник")).thenReturn(expected);

        Lion lion = new Lion("Самец", felineMock);
        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
        verify(felineMock, times(1)).getFood("Хищник");
    }
}