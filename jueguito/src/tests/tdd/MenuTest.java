package tests.tdd;

import objects.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scenes.Menu;
import main.Game;
import scenes.Playing;
import tests.DummyGraphics;
import ui.ActionBar;
import ui.MyButton;

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

    @Test
    void testButtonMouseOverTrueWhenHovered() {
        MyButton button = new MyButton("Test", 100, 100, 50, 30);
        button.setMouseOver(true);
        assertTrue(button.isMouseOver());
    }

    @Test
    void testButtonPressedState() {
        MyButton button = new MyButton("Test", 100, 100, 50, 30);
        button.setMousePressed(true);
        assertTrue(button.isMousePressed());
    }

    @Test
    void testButtonBoundsContainPoint() {
        MyButton button = new MyButton("Test", 100, 100, 50, 30);
        assertTrue(button.getBounds().contains(110, 110));
    }

    @Test
    void testRemoveLifeEndsGame() {
        ActionBar actionBar = new ActionBar(0, 0, 640, 100, new Playing(null));
        actionBar.removeOneLife(); // tenía 1 vida por defecto
        assertEquals(0, actionBar.getLives());
    }

    @Test
    public void testButtonInitialization() {
        MyButton button = new MyButton("Jugar", 100, 200, 150, 50);
        assertEquals(100, button.x);
        assertEquals(200, button.y);
        assertEquals(150, button.width);
        assertEquals(50, button.height);
    }

    @Test
    public void testSetMouseOver() {
        MyButton button = new MyButton("Test", 0, 0, 100, 50);
        button.setMouseOver(true);
        assertTrue(button.isMouseOver());
    }

    @Test
    public void testResetBooleans() {
        MyButton button = new MyButton("Test", 0, 0, 100, 50);
        button.setMousePressed(true);
        button.setMouseOver(true);
        button.resetBooleans();
        assertFalse(button.isMouseOver());
        assertFalse(button.isMousePressed());
    }

    @Test
    public void testAddGold() {
        ActionBar bar = new ActionBar(0, 640, 640, 160, null);
        bar.addGold(50);
        assertTrue(bar.getGold() >= 50); // Inicializa con 100
    }

    @Test
    public void testPayForTowerReducesGold() {
        ActionBar bar = new ActionBar(0, 640, 640, 160, null);
        int initialGold = bar.getGold();
        bar.payForTower(0); // Assuming towerType 0 exists
        assertTrue(bar.getGold() < initialGold);
    }


}
