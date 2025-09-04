package fr.campus.killthedragon.enemy;

import fr.campus.killthedragon.Interfaces.ActionOfCharacter;
import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.exception.EnnemyIsAlreadyDeadException;
import fr.campus.killthedragon.exception.PersonnageIsDeadException;
import fr.campus.killthedragon.exception.PersonnageRunException;
import fr.campus.killthedragon.game.Cell;
import fr.campus.killthedragon.game.Menu;

/**
 * Represents an enemy character in the game.
 */
public abstract class Enemy extends Cell implements ActionOfCharacter {
    protected int attack;
    protected int health;

    public Enemy() {
        super.cellType = CellType.ENEMY;
    }

    public int getAttack() {
        return attack;
    }

    public int looseHealth(int attack) {
        health -= attack;
        return health;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void interact(Character player, Menu menu) throws PersonnageRunException, PersonnageIsDeadException, EnnemyIsAlreadyDeadException {
        menu.showMessage("The enemy is a " + name);
        if(health > 0){
            String run = menu.getUserInput("\nEnter r to run or enter to fight.", null);
            if (run.equals("r")) {
                throw new PersonnageRunException("\nThe player flees the fight.");
            }
        }

        if (health <= 0) {
            throw  new EnnemyIsAlreadyDeadException(name + " is already dead.");
        }
        fight(player, menu);
    }

    public void fight(Character player, Menu menu) throws PersonnageIsDeadException {
        switch (name) {
            case "Dragon":
                menu.printDragon();
                break;
            case "Wizard":
                menu.printWizard();
                break;
            case "Goblin":
                menu.printGobelin();
                break;
        }

        menu.showMessage("⚔\uFE0F The fight start against " + name);
        while (health > 0 && player.getHealth() > 0) {
            menu.showMessage("\n☠\uFE0F You attack " + name);
            int enemyHealth = looseHealth(player.getAttack());
            menu.showMessage(name + "     ❤\uFE0F" + enemyHealth + "    \uD83D\uDDE1\uFE0F" + attack);

            if (enemyHealth <= 0) {
                menu.showMessage("☠\uFE0F " + name + " is dead");
            } else {
                menu.showMessage("☠\uFE0F " + name + " attacks you");
                int playerHealth = player.looseHealth(attack);
                menu.showMessage("Your stats ❤\uFE0F" + playerHealth + "    \uD83D\uDDE1\uFE0F" + player.getAttack());
                if (playerHealth <= 0) {
                    menu.showMessage("☠\uFE0F You are dead");
                    throw new PersonnageIsDeadException("\nThe player is dead, he has no more life.");
                }
            }
        }
    }
}
