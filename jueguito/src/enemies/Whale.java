package enemies;

import static helpz.Constants.Enemies.WHALE;

import managers.EnemyManager;

public class Whale extends Enemy {

    public Whale(float x, float y, int ID, EnemyManager em) {
        super(x, y, ID, WHALE, em);
    }

}
