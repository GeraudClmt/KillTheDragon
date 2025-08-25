package fr.campus.killthedragon.equipement;

/**
 * Represents a defensive equipment item that can be used.
 */
public class DefensiveEquipment {
    private String type = "Potion";
    private int stats = 4;

    /**
     * Returns the type of defensive equipment.
     * @return the equipment type
     */
    public String getType(){
        return type;
    }
    /**
     * Returns the stats value of the defensive equipment.
     * @return the stats value
     */
    public int getStats(){
        return stats;
    }
}
