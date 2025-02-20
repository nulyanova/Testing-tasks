import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicTest {
    protected Triangle triangle;

    @BeforeClass
    public void setUp() {
        triangle = new Triangle(0, 0, 0);
    }
    @Test
    public void testNotATriangle() {
        triangle = new Triangle(0, 0, 0);
        assert "Не треугольник".equals(triangle.triangleType());
    }

    @Test
    public void testEquilateralTriangle() {
        triangle = new Triangle(1, 1, 1);
        assert "Равносторонний треугольник".equals(triangle.triangleType());
    }

    @Test
    public void testIsoscelesTriangle() {
        triangle = new Triangle(2, 2, 3);
        assert "Равнобедренный треугольник".equals(triangle.triangleType());
    }

    @Test
    public void testScaleneTriangle() {
        triangle = new Triangle(3, 4, 5);
        assert "Разносторонний треугольник".equals(triangle.triangleType());
    }
                }