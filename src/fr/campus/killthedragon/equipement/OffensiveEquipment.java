package fr.campus.killthedragon.equipement;

/**
 * Represents an offensive equipment item used for attack.
 */
public class OffensiveEquipment {
    private String type = "Weapon";
    private int attack = 2;

    /**
     * Returns the type of offensive equipment.
     * @return the equipment type
     */
    public String getType(){
        return type;
    }
    /**
     * Returns the attack value of the offensive equipment.
     * @return the attack value
     */
    public int getAttack(){
        return attack;
    }
}
