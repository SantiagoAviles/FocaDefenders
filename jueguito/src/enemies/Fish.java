package enemies;

import static helpz.Constants.Enemies.FISH;

import managers.EnemyManager;

public class Fish extends Enemy {

    public Fish(float x, float y, int ID, EnemyManager em) {
        super(x, y, ID, FISH,em);

    }
}
