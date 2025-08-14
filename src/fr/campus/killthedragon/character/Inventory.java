package fr.campus.killthedragon.character;

import fr.campus.killthedragon.equipement.DefensiveEquipment;
import fr.campus.killthedragon.equipement.OffensiveEquipment;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {
    private DefensiveEquipment def = new DefensiveEquipment();
    private OffensiveEquipment off = new OffensiveEquipment();

    private ArrayList<OffensiveEquipment> listOff = new ArrayList<>(Arrays.asList(off, off));

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
