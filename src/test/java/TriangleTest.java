import com.example.oop.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    @Test
    public void testWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, -2, 3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, -3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, -2, 3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, -2, -3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 2, -3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, -2, -3));
    }

    @Test
    public void testWithZeroValues() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 0, 3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 0));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 0, 3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 2, 0));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 0, 0));
    }

    @Test
    public void testTriangleGetArea() {
        Triangle triangle = new Triangle(10, 7, 4);
        assertEquals(10.9287, triangle.getArea(), 0.0001);
    }
    @Test
    public void testTriangleGetPerimeter() {
        Triangle triangle = new Triangle(10, 7, 4);
        assertEquals(21, triangle.getPerimeter(), 0.0001);
    }
}