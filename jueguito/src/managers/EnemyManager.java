package managers;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Crab;
import enemies.Enemy;
import enemies.Fish;
import enemies.Octopus;
import enemies.Penguin;
import enemies.PolarBear;
import enemies.RebelSeal;
import enemies.Seagull;
import enemies.Sealion;
import enemies.Turtle;
import enemies.Whale;

import helpz.LoadSave;
import helpz.Utilz;
import objects.PathPoint;
import scenes.Playing;
import static helpz.Constants.Direction.*;
import static helpz.Constants.Tiles.*;
import static helpz.Constants.Enemies.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[] enemyImgs;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private PathPoint start, end;
	private int HPbarWidth = 50;
	private BufferedImage slowEffect;
	private int[][] roadDirArr;

	public EnemyManager(Playing playing, PathPoint start, PathPoint end) {
		this.playing = playing;
		enemyImgs = new BufferedImage[10];
		this.start = start;
		this.end = end;

		loadEffectImg();
		loadEnemyImgs();
		loadRoadDirArr();
//		tempMethod();

	}

	private void loadRoadDirArr() {
		roadDirArr = Utilz.GetRoadDirArr(playing.getGame().getTileManager().getTypeArr(), start, end);

	}

//	private void tempMethod() {
//		int[][] arr = Utilz.GetRoadDirArr(playing.getGame().getTileManager().getTypeArr(), start, end);
//
//		for (int j = 0; j < arr.length; j++) {
//			for (int i = 0; i < arr[j].length; i++) {
//				System.out.print(arr[j][i] + "|");
//			}
//			System.out.println();
//		}
//
//	}

	private void loadEffectImg() {
		slowEffect = LoadSave.getSpriteAtlas().getSubimage(32 * 9, 32 * 2, 32, 32);
	}

	private void loadEnemyImgs() {
		BufferedImage atlas = LoadSave.getSpriteAtlas();
		for (int i = 0; i < 10; i++)
			enemyImgs[i] = atlas.getSubimage(i * 32, 32, 32, 32);

	}

	public void update() {
		for (Enemy e : enemies)
			if (e.isAlive()) {
//				updateEnemyMove(e);
				updateEnemyMoveNew(e);
			}

	}

	private void updateEnemyMoveNew(Enemy e) {
		PathPoint currTile = getEnemyTile(e);
		int dir = roadDirArr[currTile.getyCord()][currTile.getxCord()];

		e.move(GetSpeed(e.getEnemyType()), dir);

		PathPoint newTile = getEnemyTile(e);

		if (!isTilesTheSame(currTile, newTile)) {
			if (isTilesTheSame(newTile, end)) {
				e.kill();
				playing.removeOneLife();
				return;
			}
			int newDir = roadDirArr[newTile.getyCord()][newTile.getxCord()];
			if (newDir != dir) {
				e.setPos(newTile.getxCord() * 32, newTile.getyCord() * 32);
				e.setLastDir(newDir);
			}
		}

	}

	private PathPoint getEnemyTile(Enemy e) {

		switch (e.getLastDir()) {
		case LEFT:
			return new PathPoint((int) ((e.getX() + 31) / 32), (int) (e.getY() / 32));
		case UP:
			return new PathPoint((int) (e.getX() / 32), (int) ((e.getY() + 31) / 32));
		case RIGHT:
		case DOWN:
			return new PathPoint((int) (e.getX() / 32), (int) (e.getY() / 32));

		}

		return new PathPoint((int) (e.getX() / 32), (int) (e.getY() / 32));
	}

	private boolean isTilesTheSame(PathPoint currTile, PathPoint newTile) {
		if (currTile.getxCord() == newTile.getxCord())
			if (currTile.getyCord() == newTile.getyCord())
				return true;
		return false;
	}

	public void updateEnemyMove(Enemy e) {
		if (e.getLastDir() == -1)
			setNewDirectionAndMove(e);

		int newX = (int) (e.getX() + getSpeedAndWidth(e.getLastDir(), e.getEnemyType()));
		int newY = (int) (e.getY() + getSpeedAndHeight(e.getLastDir(), e.getEnemyType()));

		if (getTileType(newX, newY) == ROAD_TILE) {
			e.move(GetSpeed(e.getEnemyType()), e.getLastDir());
		} else if (isAtEnd(e)) {
			e.kill();
			playing.removeOneLife();
		} else {
			setNewDirectionAndMove(e);
		}
	}

	private void setNewDirectionAndMove(Enemy e) {
		int dir = e.getLastDir();

		int xCord = (int) (e.getX() / 32);
		int yCord = (int) (e.getY() / 32);

		fixEnemyOffsetTile(e, dir, xCord, yCord);

		if (isAtEnd(e))
			return;

		if (dir == LEFT || dir == RIGHT) {
			int newY = (int) (e.getY() + getSpeedAndHeight(UP, e.getEnemyType()));
			if (getTileType((int) e.getX(), newY) == ROAD_TILE)
				e.move(GetSpeed(e.getEnemyType()), UP);
			else
				e.move(GetSpeed(e.getEnemyType()), DOWN);
		} else {
			int newX = (int) (e.getX() + getSpeedAndWidth(RIGHT, e.getEnemyType()));
			if (getTileType(newX, (int) e.getY()) == ROAD_TILE)
				e.move(GetSpeed(e.getEnemyType()), RIGHT);
			else
				e.move(GetSpeed(e.getEnemyType()), LEFT);

		}

	}

	private void fixEnemyOffsetTile(Enemy e, int dir, int xCord, int yCord) {
		switch (dir) {
		case RIGHT:
			if (xCord < 19)
				xCord++;
			break;
		case DOWN:
			if (yCord < 19)
				yCord++;
			break;
		}

		e.setPos(xCord * 32, yCord * 32);

	}

	private boolean isAtEnd(Enemy e) {
		if (e.getX() == end.getxCord() * 32)
			if (e.getY() == end.getyCord() * 32)
				return true;
		return false;
	}

	private int getTileType(int x, int y) {
		return playing.getTileType(x, y);
	}

	private float getSpeedAndHeight(int dir, int enemyType) {
		if (dir == UP)
			return -GetSpeed(enemyType);
		else if (dir == DOWN)
			return GetSpeed(enemyType) + 32;

		return 0;
	}

	private float getSpeedAndWidth(int dir, int enemyType) {
		if (dir == LEFT)
			return -GetSpeed(enemyType);
		else if (dir == RIGHT)
			return GetSpeed(enemyType) + 32;

		return 0;
	}

	public void spawnEnemy(int nextEnemy) {
		addEnemy(nextEnemy);
	}

	public void addEnemy(int enemyType) {

		int x = start.getxCord() * 32;
		int y = start.getyCord() * 32;

		switch (enemyType) {
			case FISH:
				enemies.add(new Fish(x, y, 0, this));
				break;
			case SEAGULL:
				enemies.add(new Seagull(x, y, 0, this));
				break;
			case PENGUIN:
				enemies.add(new Penguin(x, y, 0, this));
				break;
			case CRAB:
				enemies.add(new Crab(x, y, 0, this));
				break;
			case SEALION:
				enemies.add(new Sealion(x, y, 0, this));
				break;
			case OCTOPUS:
				enemies.add(new Octopus(x, y, 0, this));
				break;
			case REBELSEAL:
				enemies.add(new RebelSeal(x, y, 0, this));
				break;
			case TURTLE:
				enemies.add(new Turtle(x, y, 0, this));
				break;
			case WHALE:
				enemies.add(new Whale(x, y, 0, this));
				break;
			case POLARBEAR:
				enemies.add(new PolarBear(x, y, 0, this));
				break;
		}
	}

	public void draw(Graphics g) {
		for (Enemy e : enemies) {
			if (e.isAlive()) {
				drawEnemy(e, g);
				drawHealthBar(e, g);
				drawEffects(e, g);
			}
		}
	}

	private void drawEffects(Enemy e, Graphics g) {
		if (e.isSlowed())
			g.drawImage(slowEffect, (int) e.getX(), (int) e.getY(), null);

	}

	private void drawHealthBar(Enemy e, Graphics g) {
		int barX = (int) e.getX();
		int barY = (int) e.getY() - 10;

		int totalBarWidth = HPbarWidth;
		int currentBarWidth = (int) (HPbarWidth * e.getHealthBarFloat());

		int drawX = barX + 16 - (totalBarWidth / 2); // Centrado respecto al sprite de 32px

		// Barra de fondo (rojo = vida total)
		g.setColor(Color.red);
		g.fillRect(drawX, barY, totalBarWidth, 4);

		// Barra verde encima (vida restante)
		g.setColor(Color.green);
		g.fillRect(drawX, barY, currentBarWidth, 4);

		g.setColor(Color.black);
		g.drawRect(drawX - 1, barY - 1, totalBarWidth + 1, 5);
	}

	private int getNewBarWidth(Enemy e) {
		return (int) (HPbarWidth * e.getHealthBarFloat());
	}

	private void drawEnemy(Enemy e, Graphics g) {
		g.drawImage(enemyImgs[e.getEnemyType()], (int) e.getX(), (int) e.getY(), null);
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public int getAmountOfAliveEnemies() {
		int size = 0;
		for (Enemy e : enemies)
			if (e.isAlive())
				size++;

		return size;
	}

	public void rewardPlayer(int enemyType) {
		playing.rewardPlayer(enemyType);
	}

	public void reset() {
		enemies.clear();
	}

}
