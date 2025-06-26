package tests.BDD;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import objects.Tower;
import scenes.Playing;
import ui.ActionBar;

public class GameBDDTest {

    @Test
    void whenTowerIsSelectedAndTileIsValid_thenTowerIsPlaced() {
        // Given
        Playing playing = new Playing(null);
        Tower testTower = new Tower(0, 0, -1, 0); // tipo 0
        playing.setSelectedTower(testTower);

        // When
        int validX = 32;
        int validY = 32;

        // Simulamos que el usuario hace clic en una casilla válida
        playing.mouseClicked(validX, validY);

        // Then
        Tower placedTower = playing.getTowerManager().getTowerAt(validX, validY);
        assertNotNull(placedTower);
        assertEquals(testTower.getTowerType(), placedTower.getTowerType());
    }
}
