package fr.campus.killthedragon.enemy;

import fr.campus.killthedragon.Interfaces.ActionOfCharacter;
import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.exception.*;
import fr.campus.killthedragon.game.Cell;
import fr.campus.killthedragon.game.CriticalAttack;
import fr.campus.killthedragon.game.Menu;

/**
 * Represents an enemy character in the game.
 */
public abstract class Enemy extends Cell implements ActionOfCharacter {
    protected int attack;
    protected int health;
    private transient CriticalAttack criticalAttack;

    public Enemy() {
        super.cellType = CellType.ENEMY;
        criticalAttack = new CriticalAttack();
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

    public void fight(Character player, Menu menu) throws PersonnageIsDeadException, PersonnageRunException {
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
            int playerAttack = player.getAttack();
            int enemyAttack = attack;

            menu.showMessage("\n☠\uFE0F You attack " + name);
            playerAttack = finalAttack(menu, playerAttack);
            int enemyHealth = looseHealth(playerAttack);
            if(enemyHealth < 0){enemyHealth = 0;}
            menu.showMessage(name + "     ❤\uFE0F" + enemyHealth + "    \uD83D\uDDE1\uFE0F" + attack);

            if (enemyHealth <= 0) {
                menu.showMessage("☠\uFE0F " + name + " is dead");
            } else {
                menu.showMessage("☠\uFE0F " + name + " attacks you");
                enemyAttack = finalAttack(menu, enemyAttack);
                int playerHealth = player.looseHealth(enemyAttack);
                menu.showMessage("Your stats ❤\uFE0F" + playerHealth + "    \uD83D\uDDE1\uFE0F" + player.getAttack());
                if (playerHealth <= 0) {
                    menu.showMessage("☠\uFE0F You are dead");
                    throw new PersonnageIsDeadException("\nThe player is dead, he has no more life.");
                }
                String run = menu.getUserInput("\n💨Enter r to run or enter to continue the fight.", null);
                if (run.equals("r")) {
                    throw new PersonnageRunException("\nThe player flees the fight.");
                }
            }
        }
    }

    private int finalAttack(Menu menu, int attack) {
        try{
            criticalAttack.getCritical(9);
            menu.showMessage("It's a normal attack");
        }catch (CriticalFailureException e){
            menu.showMessage(e.getMessage());
            attack = 0;
        }catch (CriticalAttackException e){
            menu.showMessage(e.getMessage());
            attack += 2;
        }
        return attack;
    }
}
