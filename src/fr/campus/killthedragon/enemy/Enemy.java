package fr.campus.killthedragon.enemy;

import fr.campus.killthedragon.game.Cell;

/**
 * Represents an enemy character in the game.
 */
public abstract class Enemy extends Cell {
    protected int attack;
    protected int health;
    public Enemy(){
        super.cellType = CellType.ENEMY;
    }
    public int getAttack(){
        return attack;
    }
    public int loseHealth(int attack){
        health -= attack;
        return health;
    }

}
