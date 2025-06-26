package tests.bdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import ui.MyButton;

public class TowerButtonBehaviourTest {

    MyButton towerButton;

    @BeforeEach
    void setUp() {
        towerButton = new MyButton("Tower", 50, 50, 60, 60, 1);
    }

    @Test
    void givenTowerButton_whenMouseOver_thenStateIsTrue() {
        towerButton.setMouseOver(true);
        assertTrue(towerButton.isMouseOver());
    }

    @Test
    void givenTowerButton_whenClicked_thenMousePressedIsTrue() {
        towerButton.setMousePressed(true);
        assertTrue(towerButton.isMousePressed());
    }

    @Test
    void givenTowerButton_whenReset_thenAllStatesAreFalse() {
        towerButton.setMouseOver(true);
        towerButton.setMousePressed(true);
        towerButton.resetBooleans();
        assertFalse(towerButton.isMouseOver());
        assertFalse(towerButton.isMousePressed());
    }
}
