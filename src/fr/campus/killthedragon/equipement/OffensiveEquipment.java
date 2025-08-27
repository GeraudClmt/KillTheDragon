package fr.campus.killthedragon.equipement;

/**
 * Represents an offensive equipment item used for attack.
 */
public abstract class OffensiveEquipment extends Equipment{
    protected int attack;
    protected String characterType;

    public OffensiveEquipment(){
        super.type = EquipmentType.OFFENSIVE;
    }

    public int getAttack(){
        return attack;
    }

    public String forCharacter(){
        return characterType;
    }
}
