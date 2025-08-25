package fr.campus.killthedragon.character;

import fr.campus.killthedragon.equipement.DefensiveEquipment;
import fr.campus.killthedragon.equipement.OffensiveEquipment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents an inventory which can contain offensive and defensive equipment.
 */
public class Inventory {
    private DefensiveEquipment def = new DefensiveEquipment();
    private OffensiveEquipment off = new OffensiveEquipment();

    private ArrayList<OffensiveEquipment> listOff = new ArrayList<>(Arrays.asList(off, off));

    /**
     * Returns a string listing the names of offensive equipment in the inventory.
     * @return a string of weapon types in the inventory
     */
    @Override
    public String toString(){
        StringBuilder listToString = new StringBuilder();

        for (OffensiveEquipment weapon : listOff){
            if (!listToString.isEmpty()) {
                listToString.append(", ");
            }
            listToString.append(weapon.getType());
        }
        return String.valueOf(listToString);
    }
}
