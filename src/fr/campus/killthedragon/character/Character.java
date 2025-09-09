package fr.campus.killthedragon.character;

import fr.campus.killthedragon.Interfaces.ActionOfCharacter;
import fr.campus.killthedragon.equipement.Equipment;
import fr.campus.killthedragon.exception.AlreadyToInventoryException;
import fr.campus.killthedragon.game.Cell;

/**
 * Represents a character in the KillTheDragon game.
 * A character has a type, name, health points, attack points, and an inventory.
 */
public abstract class Character implements ActionOfCharacter {
    protected String type;
    protected String name;
    protected int health;
    protected int attack;
    private final Inventory inventory = new Inventory();

    /**
     * Returns a string representation of the character.
     * @return a string describing the character's type, name, health and attack
     */
    @Override
    public String toString() {
        return "Type: " + type + " Name: " + name + " Health: " + health + " Attack: " + attack;
    }

    /**
     * Increases the character's attack points by the specified value.
     * @param attack the value to add to attack points
     */
    public void setAttack(int attack) {
        this.attack += attack;
    }

    /**
     * Increases the character's health points by the specified value.
     * @param health the value to add to health points
     */
    public void setHealth(int health) {
        this.health += health;
    }

    /**
     * Returns a string describing the character's inventory.
     * @return the inventory as a string
     */
    public String getInventory() {
        return inventory.toString();
    }

    /**
     * Adds an equipment item to the character's inventory.
     * @param equipment the equipment to add
     */
    public void setToInventory(Equipment equipment) throws AlreadyToInventoryException {
        inventory.addToInventory(equipment);
    }
    /**
     * Gets the character's current attack points.
     * @return the attack points
     */


    /**
     * Returns the character's current health points.
     * @return the current health value
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the character's name.
     * @return the character name
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the character's type.
     * @return the character type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the character's attack points.
     * @return the character attack value
     */
    public int getAttack() {
        return attack;
    }
    /**
     * Decreases the character's health points by the given attack value.
     * @param attack value to subtract from the character's health
     * @return the updated health points after the attack
     */
    public int looseHealth(int attack) {
        health -= attack;
        return health;
    }
}
