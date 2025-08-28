package fr.campus.killthedragon.enemy;

import fr.campus.killthedragon.game.Cell;

/**
 * Represents an enemy character in the game.
 */
public class Enemy extends Cell {

    public Enemy(){
        super.name = "Roudoudou";
        super.cellType = CellType.ENEMY;
    }
}
