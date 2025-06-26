package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Game;
import ui.MyButton;

import static main.GameStates.*;

public class Menu extends GameScene implements SceneMethods {

	private MyButton bPlaying, bEdit, bSettings, bQuit;

	public Menu(Game game) {
		super(game);
		initButtons();
	}

	private void initButtons() {
		int w = 200;
		int h = 60;
		int x = 640 / 2 - w / 2;
		int y = 200;
		int yOffset = 70;

		bPlaying = new MyButton("Jugar", x, y, w, h);
		bEdit = new MyButton("Modificar Mapa", x, y + yOffset, w, h);
		bSettings = new MyButton("Ajustes", x, y + yOffset * 2, w, h);
		bQuit = new MyButton("Salir", x, y + yOffset * 3, w, h);
	}

	@Override
	public void render(Graphics g) {
		drawBackground(g);
		drawTitle(g);
		drawButtons(g);
	}

	private void drawBackground(Graphics g) {
		g.setColor(new Color(30, 30, 30)); // fondo oscuro
		g.fillRect(0, 0, 640, 800);
	}

	private void drawTitle(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("LucidaSans", Font.BOLD, 48));
		g.drawString("Foca Defenders", 640 / 2 - 180, 120);
	}

	private void drawButtons(Graphics g) {
		bPlaying.draw(g);
		bEdit.draw(g);
		bSettings.draw(g);
		bQuit.draw(g);
	}

	@Override
	public void mouseClicked(int x, int y) {
		if (bPlaying.getBounds().contains(x, y))
			SetGameState(PLAYING);
		else if (bEdit.getBounds().contains(x, y))
			SetGameState(EDIT);
		else if (bSettings.getBounds().contains(x, y))
			SetGameState(SETTINGS);
		else if (bQuit.getBounds().contains(x, y))
			System.exit(0);
	}

	@Override
	public void mouseMoved(int x, int y) {
		bPlaying.setMouseOver(bPlaying.getBounds().contains(x, y));
		bEdit.setMouseOver(bEdit.getBounds().contains(x, y));
		bSettings.setMouseOver(bSettings.getBounds().contains(x, y));
		bQuit.setMouseOver(bQuit.getBounds().contains(x, y));
	}

	@Override
	public void mousePressed(int x, int y) {
		bPlaying.setMousePressed(bPlaying.getBounds().contains(x, y));
		bEdit.setMousePressed(bEdit.getBounds().contains(x, y));
		bSettings.setMousePressed(bSettings.getBounds().contains(x, y));
		bQuit.setMousePressed(bQuit.getBounds().contains(x, y));
	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
	}

	private void resetButtons() {
		bPlaying.resetBooleans();
		bEdit.resetBooleans();
		bSettings.resetBooleans();
		bQuit.resetBooleans();
	}

	@Override
	public void mouseDragged(int x, int y) {
		// No se utiliza en el menú
	}
}
