import com.example.oop.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    @Test
    public void testWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 0, 3));
    }

    @Test
    public void testTriangleGetArea() {
        Triangle triangle1 = new Triangle(10, 7, 4);
        Triangle triangle2 = new Triangle(3, 6, 5);
        Triangle triangle3 = new Triangle(8, 9, 2);

        assertEquals(10.9287, triangle1.getArea(), 0.0001);
        assertEquals(7.4833, triangle2.getArea(), 0.0001);
        assertEquals(7.31, triangle3.getArea(), 0.0001);

    }
    @Test
    public void testTriangleGetPerimeter() {
        Triangle triangle1 = new Triangle(10, 7, 4);
        Triangle triangle2 = new Triangle(3, 6, 5);
        Triangle triangle3 = new Triangle(8, 9, 2);
        assertEquals(21, triangle1.getPerimeter());
        assertEquals(14, triangle2.getPerimeter());
        assertEquals(19, triangle3.getPerimeter());
    }
}