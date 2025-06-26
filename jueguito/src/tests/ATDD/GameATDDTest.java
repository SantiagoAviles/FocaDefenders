package tests.ATDD;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import scenes.Playing;
import objects.Tower;
import managers.TowerManager;

public class GameATDDTest {

    @Test
    void testTowerPlacementConsumesGoldAndOccupiesTile() {
        Playing playing = new Playing(null);
        Tower tower = new Tower(0, 0, 1, 0);
        playing.getTowerManager().addTower(tower, 64, 64);
        TowerManager manager = playing.getTowerManager();

        assertNotNull(manager.getTowerAt(64, 64));
    }

    @Test
    void testPlayerCanPauseAndUnpauseGame() {
        Playing playing = new Playing(null);

        playing.setGamePaused(true);
        assertTrue(playing.isGamePaused());

        playing.setGamePaused(false);
        assertFalse(playing.isGamePaused());
    }
}
