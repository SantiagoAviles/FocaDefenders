package tests.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ui.MyButton;
import java.awt.Rectangle;

public class MyButtonTest {

    @Test
    void testInitialState() {
        MyButton btn = new MyButton("Test", 10, 20, 100, 40);
        Rectangle expected = new Rectangle(10, 20, 100, 40);
        assertEquals(expected, btn.getBounds());
        assertFalse(btn.isMouseOver());
        assertFalse(btn.isMousePressed());
    }

    @Test
    void testMouseOverState() {
        MyButton btn = new MyButton("Hover", 0, 0, 100, 50);
        btn.setMouseOver(true);
        assertTrue(btn.isMouseOver());
    }

    @Test
    void testMousePressedState() {
        MyButton btn = new MyButton("Press", 0, 0, 100, 50);
        btn.setMousePressed(true);
        assertTrue(btn.isMousePressed());
    }
}
