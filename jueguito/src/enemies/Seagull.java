package enemies;

import static helpz.Constants.Enemies.SEAGULL;

import managers.EnemyManager;

public class Seagull extends Enemy {

	public Seagull(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, SEAGULL,em);
		
	}

}
