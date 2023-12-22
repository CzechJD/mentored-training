import com.example.oop.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    @Test
    public void testWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-3, 5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5, -3));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-3, -5));
    }

    @Test
    public void testWithZeroValues() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5, 0));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 0));
    }

    @Test
    public void testRectangleGetArea() {
        Rectangle rectangle = new Rectangle(3, 5);
        assertEquals(15, rectangle.getArea(), 0.0001);
    }

    @Test
    public void testRectangleGetPerimeter() {
        Rectangle rectangle = new Rectangle(3, 5);
        assertEquals(16, rectangle.getPerimeter(), 0.0001);
    }
}
