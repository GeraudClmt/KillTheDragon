package fr.campus.killthedragon.game;

import fr.campus.killthedragon.enemy.Enemy;
import fr.campus.killthedragon.equipement.OffensiveEquipment;
/**
 * Represents a single cell (case) on the game board.
 */
public class Case {
    private final CellType type;
    private Enemy enemy = null;
    private OffensiveEquipment  offensiveEquipment = null;
    /**
     * Constructs a new case of the given cell type.
     * @param type the type of the case
     */
    public Case(CellType type){
        this.type = type;
        if(this.type == CellType.BONUS){
            offensiveEquipment = new OffensiveEquipment();
        } else if (this.type == CellType.ENEMY) {
            enemy = new Enemy();
        }
    }

    /**
     * Cell types for the board (empty, bonus, enemy, final).
     */
    public enum CellType{
        EMPTY,
        BONUS,
        ENEMY,
        FINAL,
    }
    /**
     * Checks if this case is empty.
     * @return {@code true} if the case is EMPTY; {@code false} otherwise
     */
    public boolean isEmpty(){
        return type == CellType.EMPTY;
    }

    /**
     * Returns the name of the cell type as a string.
     * @return the cell type name
     */
    @Override
    public String toString(){
        return type.name();
    }

    public CellType getType(){
        return type;
    }

    public OffensiveEquipment getEquipment(){
        return offensiveEquipment;
    }
    public Enemy getEnemy(){
        return enemy;
    }
}
