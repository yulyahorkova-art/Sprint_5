import com.example.Animal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class AnimalParameterizedTest {

    private final Animal animal = new Animal();

    static Stream<Arguments> foodData() {
        return Stream.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
        );
    }

    @ParameterizedTest
    @MethodSource("foodData")
    void getFood_validKind_returnsCorrectList(String kind, List<String> expected) throws Exception {
        assertEquals(expected, animal.getFood(kind));
    }
}