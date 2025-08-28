package fr.campus.killthedragon.character;

import fr.campus.killthedragon.equipement.Equipment;

/**
 * Represents a character in the KillTheDragon game.
 * A character has a type, name, health points, attack points, and an inventory.
 */
public abstract class Character {
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

    public void setToInventory(Equipment equipment){
        inventory.setToInventory(equipment);
    }
    /**
     * Gets the character's current attack points.
     * @return the attack points
     */
    public int getAttack() {
        return this.attack;
    }
}
