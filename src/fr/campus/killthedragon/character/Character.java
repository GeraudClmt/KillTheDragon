package fr.campus.killthedragon.character;

import fr.campus.killthedragon.character.Inventory;

public class Character {
    private String type;
    private String name;
    private  int health = 10;
    private int attack = 4;
    private Inventory inventory = new Inventory();

    public Character(String type, String name){
        this.type = type;
        this.name = name;
    }
    public String toString(){
        return "Type: " + type + " Name: " + name + " Health: " + health + " Attack: " + attack;
    }
    public void setAttack(int attack){
        this.attack += attack;
    }
    public void setHealth(int health){
        this.health += health;
    }
    public String getInventory(){
        return inventory.toString();
    }
    public int getAttack(){
        return this.attack;
    }
}
