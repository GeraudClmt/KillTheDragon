package fr.campus.killthedragon.game;
import fr.campus.killthedragon.exception.PersonnageHorsPlateauException;
import fr.campus.killthedragon.game.Case;
import fr.campus.killthedragon.game.Menu;

import java.util.ArrayList;
import java.util.Random;


/**
 * Represents the game board containing cases for the player to move on.
 */
public class Board {
    private final Menu menu = new Menu();
    private final int numberCase;
    private final ArrayList<Case> casesList;
    private int caseOfGamer = 1;

    /**
     * Constructs the Board with a predefined number of cases, bonus, and enemies.
     */
    public Board(int numberCase, int nbBonusCases, int nbEnemiesCases){
        this.numberCase = numberCase;
        casesList = new ArrayList<>(numberCase);

        for(int i = 0; i <= numberCase; i++){
            if(i == numberCase){
                casesList.add(new Case(Case.CellType.FINAL));
            }else{
                casesList.add(new Case(Case.CellType.EMPTY));
            }
        }

        setCaseBonusAndEnemy(nbBonusCases, Case.CellType.BONUS);
        setCaseBonusAndEnemy(nbEnemiesCases, Case.CellType.ENEMY);
    }

    /**
     * Updates the player's case position by adding the given number of cases.
     * @param addCase the number of cases to move forward
     */
    public void setCaseOfGamer(int addCase){
        menu.showMessage("You move forward " + addCase + " cases");
        try {
            caseOfGamer += checkIfOutTheBoard(addCase);
            menu.showMessage("You arrived on case " + caseOfGamer+ ", it's a " + casesList.get(caseOfGamer).toString() + " case.");
        }catch (PersonnageHorsPlateauException e){
            caseOfGamer = casesList.toArray().length - 1;
            menu.showMessage(e.getMessage());
        }
    }

    public int checkIfOutTheBoard(int addCase) throws PersonnageHorsPlateauException {
        if (addCase + caseOfGamer > casesList.toArray().length -1){
            throw new PersonnageHorsPlateauException("You are arrived on the last case.");
        }
        return  addCase;
    }

    /**
     * Returns the current case number of the player.
     * @return the player's case number
     */
    public int getCaseOfGamer(){return caseOfGamer;}

    /**
     * Assigns bonus or enemy cases randomly on the board.
     * @param nbCases the number of cases
     * @param type the type of case (BONUS or ENEMY)
     */
    private void setCaseBonusAndEnemy(int nbCases, Case.CellType type){
        Random rand = new Random();

        for(int i = 0; i < nbCases; i++){
            boolean isNotEmpty = true;
            while(isNotEmpty) {
                int randomCase = rand.nextInt(numberCase - 2) + 2;
                if (casesList.get(randomCase).isEmpty()) {
                    casesList.set(randomCase, new Case(type));
                    isNotEmpty = false;
                }
            }
        }
    }

    public Case getCaseOfPlayer(){
        return casesList.get(caseOfGamer);
    }

    public int getNumberCase(){
        return numberCase;
    }
}
