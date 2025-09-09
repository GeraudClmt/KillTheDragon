package fr.campus.killthedragon.character;

import fr.campus.killthedragon.equipement.Equipment;
import fr.campus.killthedragon.exception.AlreadyToInventoryException;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an inventory which can contain offensive and defensive equipment.
 */
public class Inventory {
    private final List<Equipment> equipmentList;

    /**
     * Creates a new, empty inventory.
     */
    public Inventory(){
        equipmentList = new ArrayList<>();
    }
    /**
     * Returns a string listing the names of offensive equipment in the inventory.
     * @return a string of weapon types in the inventory
     */
    @Override
    public String toString(){
        StringBuilder listToString = new StringBuilder();

        for (Equipment weapon : equipmentList){
            if (!listToString.isEmpty()) {
                listToString.append(", ");
            }
            listToString.append(weapon.getName());
        }
        return String.valueOf(listToString);
    }
    
    /**
     * Adds equipment to the inventory.
     * @param equipment Equipment to add to the inventory
     */
    public void addToInventory(Equipment equipment) throws AlreadyToInventoryException {
        for (Equipment element : equipmentList) {
            if (equipment.getName().equals(element.getName()) && equipment.getType() != Equipment.EquipmentType.HEALTH) {
                throw new AlreadyToInventoryException("Already in Inventory");
            }
        }

        equipmentList.add(equipment);
    }

    /**
     * Removes all equipment from the inventory.
     */
    public void removeAllInventory(){
        equipmentList.clear();
    }

    /**
     * Removes one equipment item from the inventory by name.
     * @param equipmentName Name of the equipment to remove
     */
    public void removeToInventory(String equipmentName){
        for(int i = 0; i < equipmentList.size(); i++){
            if(equipmentName.equals(equipmentList.get(i).getName())){
                equipmentList.remove(i);
                break;
            }
        }
    }

    /**
     * Removes the specified equipment from the inventory.
     * @param equipment Equipment object to remove
     */
    public void removeFromInventory(Equipment equipment){
        equipmentList.remove(equipment);
    }

    public void isAlreadyToInventory(Equipment equipment){

    }
}
