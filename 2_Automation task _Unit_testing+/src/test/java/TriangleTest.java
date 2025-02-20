/* Тестовый класс TriangleTest охватывает основные сценарии,
включая граничные случаи, негативные случаи и обработку нечислового ввода.*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @ParameterizedTest // Аннотация, указывающая, что метод testTriangleType является параметризованным тестом.
    @CsvSource({
            "0, 0, 0, Не треугольник",
            "1, 1, 1, Равносторонний треугольник",
            "1, 1, 2, Не треугольник",
            "1, 2, 2, Равнобедренный треугольник",
            "-1, 1, 1, Не треугольник",
            "1, 2, 3, Не треугольник",
            "1000, 1000, 1000, Равносторонний треугольник",
            "1000, 1000, 1500, Равнобедренный треугольник",
            "5, 5, 10, Не треугольник",
            "5, 6, 7, Разносторонний треугольник",
            "2, 3, 4, Разносторонний треугольник", // Минимальные значения для разностороннего
            "999, 998, 997, Разносторонний треугольник", // Максимальные значения для разностороннего (близкие к 1000)
            "1000, 999, 998, Разносторонний треугольник"
    })

    /* Проверяет корректность определения типа треугольника для различных комбинаций длин сторон,
    включая равносторонние, равнобедренные, разносторонние треугольники и случаи, когда треугольник не может существовать.*/
    void testTriangleType(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals(expected, triangle.triangleType());
    }

    @ParameterizedTest
    @CsvSource({
            "'a', 1, 1",
            "1, 'b', 1",
            "1, 1, 'c'"
    })

    /* Тестирует устойчивость программы к некорректному вводу*/
    void testInvalidInput(String a, String b, String c) {
        assertThrows(NumberFormatException.class, () -> {
            int sideA = Integer.parseInt(a);
            int sideB = Integer.parseInt(b);
            int sideC = Integer.parseInt(c);
            Triangle triangle = new Triangle(sideA, sideB, sideC);
            triangle.triangleType();
        });
    }
}