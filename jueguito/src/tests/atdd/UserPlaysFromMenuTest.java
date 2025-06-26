package tests.atdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import scenes.Menu;
import main.Game;
import main.GameStates;

public class UserPlaysFromMenuTest {

    Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu(new Game());
    }

    @Test
    void whenUserClicksJugar_thenGameStateIsPlaying() {
        menu.mouseClicked(320, 160); // posición del botón 'Jugar'
        assertEquals(GameStates.PLAYING, GameStates.gameState);
    }
}
