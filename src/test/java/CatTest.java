import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    void getSound_shouldReturnMeow() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFood_shouldDelegateToFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        List<String> actual = cat.getFood();

        assertEquals(expectedFood, actual);
        verify(felineMock, times(1)).eatMeat();
    }
}