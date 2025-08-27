package fr.campus.killthedragon.equipement;

/**
 * Represents a defensive equipment item that can be used.
 */
public class DefensiveEquipment extends Equipment{
    protected int defense;
    protected String characterType;

    public DefensiveEquipment(){
        super.type = EquipmentType.DEFENSIVE;
    }

    public int getDefense(){
        return defense;
    }

    public String forCharacter(){
        return characterType;
    }
}
