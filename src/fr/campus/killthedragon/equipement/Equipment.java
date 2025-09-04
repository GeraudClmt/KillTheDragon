package fr.campus.killthedragon.equipement;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.game.Cell;
import fr.campus.killthedragon.game.Menu;

public abstract class Equipment extends Cell {
    protected EquipmentType type;

    public Equipment() {
        super.cellType = CellType.BONUS;
    }

    public enum EquipmentType {
        OFFENSIVE,
        DEFENSIVE,
        HEALTH,
    }

    public EquipmentType getType() {
        return type;
    }

    @Override
    public void interact(Character player, Menu menu) {
        menu.printChest();
        menu.showMessage("\uD83D\uDDDD\uFE0F You found " + name + " in chest.");
        player.setToInventory(this);
        //menu.showMessage("Inventory " + player.getInventory());
        if (this instanceof OffensiveEquipment offensiveEquipment) {
            if (player.getType().equals(offensiveEquipment.forCharacter())) {
                player.setAttack(offensiveEquipment.getAttack());
                menu.showMessage(name + " is équipped, you have " + player.getAttack() + " attacks");
            } else {
                menu.showMessage(name + " is not compatible with " + player.getType());
            }

        } else if (this instanceof HealthEquipment healthEquipment) {
            player.setHealth(healthEquipment.getHealth());
            menu.showMessage("You win " + healthEquipment.getHealth() + " life points, you have " + player.getHealth() + " health");
        }
    }
}
