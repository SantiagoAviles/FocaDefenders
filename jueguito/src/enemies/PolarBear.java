package enemies;

import static helpz.Constants.Enemies.POLARBEAR;

import managers.EnemyManager;

public class PolarBear extends Enemy {

    public PolarBear(float x, float y, int ID, EnemyManager em) {
        super(x, y, ID, POLARBEAR,em);

    }
}
