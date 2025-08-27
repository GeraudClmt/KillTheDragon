package fr.campus.killthedragon.equipement;

public class HealthEquipment extends Equipment{
    protected int life;
    public HealthEquipment(){
        super.type = EquipmentType.HEALTH;
    }

    public int getHealth(){
        return life;
    }
}
