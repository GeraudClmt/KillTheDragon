package fr.campus.killthedragon.character;

import fr.campus.killthedragon.character.Inventory;

/**
 * Represents a character in the KillTheDragon game.
 * A character has a type, name, health points, attack points, and an inventory.
 */
public class Character {
    private String type;
    private String name;
    private int health = 10;
    private int attack = 4;
    private Inventory inventory = new Inventory();

    /**
     * Constructs a new Character instance.
     * @param type the character's type
     * @param name the character's name
     */
    public Character(String type, String name) {
        this.type = type;
        this.name = name;
    }

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
     * Gets the character's current attack points.
     * @return the attack points
     */
    public int getAttack() {
        return this.attack;
    }
}
