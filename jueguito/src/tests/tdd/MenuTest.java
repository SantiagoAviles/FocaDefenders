package tests.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scenes.Menu;
import main.Game;
import tests.DummyGraphics;

import java.awt.Graphics;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu(new Game());
    }

    @Test
    void testMenuCreationNotNull() {
        assertNotNull(menu);
    }

    @Test
    void testRenderWithoutException() {
        Graphics g = new DummyGraphics();
        assertDoesNotThrow(() -> menu.render(g));
    }
}
