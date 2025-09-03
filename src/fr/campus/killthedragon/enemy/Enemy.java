package fr.campus.killthedragon.enemy;

import fr.campus.killthedragon.Interfaces.ActionOfCharacter;
import fr.campus.killthedragon.game.Cell;

/**
 * Represents an enemy character in the game.
 */
public abstract class Enemy extends Cell implements ActionOfCharacter {
    protected int attack;
    protected int health;
    public Enemy(){
        super.cellType = CellType.ENEMY;
    }
    public int getAttack(){
        return attack;
    }
    public int looseHealth(int attack){
        health -= attack;
        return health;
    }

}
