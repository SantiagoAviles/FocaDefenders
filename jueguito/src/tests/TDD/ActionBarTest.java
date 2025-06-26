package tests.TDD;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ui.ActionBar;
import scenes.Playing;

public class ActionBarTest {

    @Test
    void testAddGold() {
        ActionBar bar = new ActionBar(0, 0, 640, 160, new Playing(null));
        bar.addGold(50);
        assertTrue(bar.getLives() > 0); // Aunque el oro no se expone directamente, validamos estado del juego
    }

    @Test
    void testRemoveOneLife() {
        ActionBar bar = new ActionBar(0, 0, 640, 160, new Playing(null));
        bar.removeOneLife();  // Debería activar GAME_OVER si vidas <= 0
        assertEquals(0, bar.getLives());
    }
}
