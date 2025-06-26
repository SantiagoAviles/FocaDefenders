package enemies;

import static helpz.Constants.Enemies.PENGUIN;

import managers.EnemyManager;

public class Penguin extends Enemy {

	public Penguin(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, PENGUIN,em);

	}
}
