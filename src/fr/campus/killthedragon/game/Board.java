package fr.campus.killthedragon.game;
import fr.campus.killthedragon.game.Case;
import fr.campus.killthedragon.game.Menu;

import java.util.ArrayList;
import java.util.Random;


public class Board {
    private final Menu menu = new Menu();
    private int numberCase;
    private ArrayList<Case> casesList;
    private int nbBonusCases;
    private int nbEnnemiesCases;
    private int caseOfGamer = 1;

    public Board(){
        numberCase = 64;
        nbBonusCases = 10;
        nbEnnemiesCases = 10;
        casesList = new ArrayList<>(numberCase);

        for(int i = 0; i <= numberCase; i++){
            if(i == numberCase){
                casesList.add(new Case(Case.CellType.FINAL));
            }else{
                casesList.add(new Case(Case.CellType.EMPTY));
            }
        }

        setCaseBonusAndEnemy(nbBonusCases, Case.CellType.BONUS);
        setCaseBonusAndEnemy(nbEnnemiesCases, Case.CellType.ENEMY);
    }

    public void setCaseOfGamer(int addCase){
        menu.showMessage("You move forward " + addCase + " cases");
        if(caseOfGamer + addCase > numberCase){
            caseOfGamer = 64;
        }else{
            caseOfGamer += addCase;
        }
        getCaseTypeOfPlayer();
    }

    public int getCaseOfGamer(){
        return caseOfGamer;
    }

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

    public void getCaseTypeOfPlayer(){
        menu.showMessage("You arrived on case " + caseOfGamer+ ", it's a " + casesList.get(caseOfGamer).toString() + " case.");
    }
}
