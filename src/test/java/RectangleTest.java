import com.example.oop.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    @Test
    public void testWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-3, 5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-3, -5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5, 0));
    }


    @Test
    public void testRectangleGetArea() {
        Rectangle rectangle1 = new Rectangle(1, 3);
        Rectangle rectangle2 = new Rectangle(3, 5);
        Rectangle rectangle3 = new Rectangle(7, 9);

        assertEquals(3, rectangle1.getArea(), 0.0001);
        assertEquals(15, rectangle2.getArea(), 0.0001);
        assertEquals(63, rectangle3.getArea(), 0.0001);
    }

    @Test
    public void testRectangleGetPerimeter() {
        Rectangle rectangle1 = new Rectangle(3, 5);
        Rectangle rectangle2 = new Rectangle(2, 5);
        Rectangle rectangle3 = new Rectangle(6, 5);

        assertEquals(16, rectangle1.getPerimeter(), 0.0001);
        assertEquals(14, rectangle2.getPerimeter(), 0.0001);
        assertEquals(22, rectangle3.getPerimeter(), 0.0001);
    }
}
