package tests.TDD;

import managers.TowerManager;
import org.junit.jupiter.api.Test;
import scenes.Playing;
import objects.Tower;

import static org.junit.jupiter.api.Assertions.*;

public class TowerManagerTest {

    @Test
    void testAddTowerIncreasesCount() {
        Playing playing = new Playing(null);
        TowerManager manager = new TowerManager(playing);
        Tower tower = new Tower(32, 32, 1, 0);

        manager.addTower(tower, 32, 32);

        assertEquals(tower, manager.getTowerAt(32, 32));
    }

    @Test
    void testRemoveTower() {
        Playing playing = new Playing(null);
        TowerManager manager = new TowerManager(playing);
        Tower tower = new Tower(32, 32, 1, 0);

        manager.addTower(tower, 32, 32);
        manager.removeTower(tower);

        assertNull(manager.getTowerAt(32, 32));
    }
}
