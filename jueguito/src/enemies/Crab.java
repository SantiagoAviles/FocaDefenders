package enemies;

import static helpz.Constants.Enemies.CRAB;

import managers.EnemyManager;

public class Crab extends Enemy {

    public Crab(float x, float y, int ID, EnemyManager em) {
        super(x, y, ID, CRAB,em);

    }
}
