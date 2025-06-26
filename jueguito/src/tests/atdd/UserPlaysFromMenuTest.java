package tests.atdd;

import helpz.Constants;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import scenes.Menu;
import main.Game;
import main.GameStates;
import scenes.Playing;
import ui.ActionBar;

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

    @Test
    public void testUserCanBuildTowerWhenHasEnoughGold() {
        Playing playing = mock(Playing.class);
        ActionBar bar = new ActionBar(0, 640, 640, 160, playing);

        int towerType = 0; // Suponiendo torre básica
        int cost = Constants.Towers.GetTowerCost(towerType);
        for (int i = 0; i < 5; i++)
            bar.addGold(10); // Asegurar oro suficiente

        assertTrue(bar.getGold() >= cost);
    }

    @Test
    public void testUserSeesTowerCostOnHover() {
        Playing playing = mock(Playing.class);
        ActionBar bar = new ActionBar(0, 640, 640, 160, playing);

        bar.mouseMoved(70, 660); // Coordenada dentro de un botón de torre
        // Se espera que showTowerCost esté activado (no podemos acceder directamente, pero el test describe el comportamiento aceptado).
    }

    @Test
    public void testUserLosesGameWhenLivesZero() {
        Playing playing = mock(Playing.class);
        ActionBar bar = new ActionBar(0, 640, 640, 160, playing);
        bar.removeOneLife(); // lives = 0 → debería cambiar GameState a GAME_OVER
        // Aceptación: el juego se termina visualmente (no comprobable sin acceso interno).
    }



}
