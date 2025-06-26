package enemies;

import static helpz.Constants.Enemies.SEALION;

import managers.EnemyManager;

public class Sealion extends Enemy {

	public Sealion(float x, float y, int ID, EnemyManager em) {

		super(x, y, ID, SEALION, em);
	}

}
