package fr.campus.killthedragon.game;

import fr.campus.killthedragon.enemy.Enemy;
import fr.campus.killthedragon.equipement.*;
import fr.campus.killthedragon.equipement.deffensive.Cape;
import fr.campus.killthedragon.equipement.deffensive.Shield;
import fr.campus.killthedragon.equipement.health.BigPotion;
import fr.campus.killthedragon.equipement.health.SmallPotion;
import fr.campus.killthedragon.equipement.offensive.Club;
import fr.campus.killthedragon.equipement.offensive.FireBall;
import fr.campus.killthedragon.equipement.offensive.Flash;
import fr.campus.killthedragon.equipement.offensive.Sword;

import java.util.Random;

/**
 * Represents a single cell (case) on the game board.
 */
public class Case {
    private final CellType type;
    private Enemy enemy = null;
    private Equipment equipment = null;
    /**
     * Constructs a new case of the given cell type.
     * @param type the type of the case
     */
    public Case(CellType type){
        this.type = type;
        if(this.type == CellType.BONUS){
            equipment = getRandomEquipment();
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

    public Equipment getEquipment(){
        return equipment;
    }
    public Enemy getEnemy(){
        return enemy;
    }

    private Equipment getRandomEquipment(){
        Random random = new Random();
        int randomNumber = random.nextInt(8);

        return switch (randomNumber) {
            case 0 -> new BigPotion();
            case 1 -> new Cape();
            case 2 -> new Club();
            case 3 -> new FireBall();
            case 4 -> new Flash();
            case 5 -> new Shield();
            case 6 -> new Sword();
            default -> new SmallPotion();
        };
    }
}
