package fr.campus.killthedragon.equipement;

import fr.campus.killthedragon.game.Cell;

public abstract class Equipment extends Cell {
    protected EquipmentType type;

    public Equipment(){
        super.cellType = CellType.BONUS;
    }
    public enum EquipmentType{
        OFFENSIVE,
        DEFENSIVE,
        HEALTH,
    }
}
