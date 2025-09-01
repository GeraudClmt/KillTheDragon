package fr.campus.killthedragon.character;


public class Mage extends Character{

    public Mage(String name){
        super.name = name;
        super.type = "Mage";
        super.health = 6;
        super.attack = 8;
    }
    public Mage(String name, int Health, int attack){
        super.name = name;
        super.type = "Mage";
        super.health = 6;
        super.attack = 8;
        super.health = Health;
        super.attack = attack;
    }
}
