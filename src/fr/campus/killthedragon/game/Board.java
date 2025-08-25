package fr.campus.killthedragon.game;
import fr.campus.killthedragon.game.Case;
import fr.campus.killthedragon.game.Menu;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Menu menu = new Menu();
    private int numberCase;
    private List<Case> casesList = new ArrayList<>();
    private int nbBonusCases;
    private int nbEnnemiesCases;
    private int caseOfGamer = 1;

    public Board(){
        this.numberCase = 64;
        this.nbBonusCases = 10;
        this.nbEnnemiesCases = 8;


    }
    public void setCaseOfGamer(int addCase){
        menu.showMessage("You move forward " + addCase + " cases");
        if(this.caseOfGamer + addCase > this.numberCase){
            this.caseOfGamer = 64;
        }else{
            this.caseOfGamer += addCase;
        }
        menu.showMessage("You arrived on the case " + this.caseOfGamer);
    }
    public int getCaseOfGamer(){
        return this.caseOfGamer;
    }
}
