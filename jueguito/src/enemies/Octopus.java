package enemies;

import static helpz.Constants.Enemies.OCTOPUS;

import managers.EnemyManager;

public class Octopus extends Enemy {

    public Octopus(float x, float y, int ID, EnemyManager em) {
        super(x, y, ID, OCTOPUS,em);

    }
}
