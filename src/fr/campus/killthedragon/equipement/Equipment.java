package fr.campus.killthedragon.equipement;

public abstract class Equipment {
    protected String name;
    protected EquipmentType type;

    public enum EquipmentType{
        OFFENSIVE,
        DEFENSIVE,
        HEALTH,
    }

    public EquipmentType getType(){
        return type;
    }
    public String getName(){
        return name;
    }
}
