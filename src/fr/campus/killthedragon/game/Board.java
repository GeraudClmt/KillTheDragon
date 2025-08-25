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
        this.numberCase = 64;
        this.nbBonusCases = 10;
        this.nbEnnemiesCases = 10;
        this.casesList = new ArrayList<>(this.numberCase);

        for(int i = 0; i <= this.numberCase; i++){
            if(i == this.numberCase){
                this.casesList.add(new Case(Case.CellType.FINAL));
            }else{
                this.casesList.add(new Case(Case.CellType.EMPTY));
            }
        }

        setCaseBonusAndEnemy(this.nbBonusCases, Case.CellType.BONUS);
        setCaseBonusAndEnemy(this.nbEnnemiesCases, Case.CellType.ENEMY);
    }

    public void setCaseOfGamer(int addCase){
        menu.showMessage("You move forward " + addCase + " cases");
        if(this.caseOfGamer + addCase > this.numberCase){
            this.caseOfGamer = 64;
        }else{
            this.caseOfGamer += addCase;
        }
        getCaseTypeOfPlayer();
    }

    public int getCaseOfGamer(){
        return this.caseOfGamer;
    }

    private void setCaseBonusAndEnemy(int nbCases, Case.CellType type){
        Random rand = new Random();

        for(int i = 0; i < nbCases; i++){
            boolean isNotEmpty = true;
            while(isNotEmpty) {
                int randomCase = rand.nextInt(this.numberCase - 2) + 2;
                if (this.casesList.get(randomCase).isEmpty()) {
                    this.casesList.set(randomCase, new Case(type));
                    isNotEmpty = false;
                }
            }
        }
    }

    public void getCaseTypeOfPlayer(){
        menu.showMessage("You arrived on case " + this.caseOfGamer+ ", it's a " + this.casesList.get(caseOfGamer).toString() + " case.");
    }
}
