package enemies;

import static helpz.Constants.Enemies.TURTLE;

import managers.EnemyManager;

public class Turtle extends Enemy {

    public Turtle(float x, float y, int ID, EnemyManager em) {
        super(x, y, ID, TURTLE,em);

    }
}
