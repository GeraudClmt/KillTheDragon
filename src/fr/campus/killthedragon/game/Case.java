package fr.campus.killthedragon.game;

import fr.campus.killthedragon.enemy.Enemy;
import fr.campus.killthedragon.equipement.OffensiveEquipment;
public class Case {
    private CellType type;

    public Case(CellType type){
        this.type = type;
    }

    public enum CellType{
        EMPTY,
        BONUS,
        ENEMY,
        FINAL,
    }
    public boolean isEmpty(){
        return this.type == CellType.EMPTY;
    }

    public String toString(){
        return this.type.name();
    }
}
