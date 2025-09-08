package fr.campus.killthedragon.game;

import com.google.gson.*;
import com.google.gson.JsonObject;
import fr.campus.killthedragon.enemy.Dragon;
import fr.campus.killthedragon.enemy.Gobelin;
import fr.campus.killthedragon.enemy.Wizard;
import fr.campus.killthedragon.equipement.health.BigPotion;
import fr.campus.killthedragon.equipement.health.SmallPotion;
import fr.campus.killthedragon.equipement.offensive.Club;
import fr.campus.killthedragon.equipement.offensive.FireBall;
import fr.campus.killthedragon.equipement.offensive.Flash;
import fr.campus.killthedragon.equipement.offensive.Sword;
import fr.campus.killthedragon.exception.PersonnageHorsPlateauException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * Represents the game board containing cases for the player to move on.
 */
public class Board {
    private transient final Menu menu;
    private final int numberCase;
    private final List<Cell> casesList;
    private int caseOfGamer;

    /**
     * Constructs the Board with a predefined number of cases, bonus, and enemies.
     */
    public Board(Menu menu,int numberCase, int caseOfGamer, boolean isOnlyEmptyCell) {
        int dragonCases = 4;
        int wizardCases = 10;
        int gobelinCases = 10;

        int clubCases = 5;
        int swordCases = 4;
        int flashCases = 5;
        int fireballCases = 2;
        int bigPotionCases = 6;
        int smallCases = 2;


        this.menu = menu;
        this.caseOfGamer = caseOfGamer;
        this.numberCase = numberCase;
        casesList = new ArrayList<>(numberCase);

        for (int i = 0; i <= 64; i++) {
            if (i == numberCase) {
                casesList.add(new FinalCell());
            } else {
                casesList.add(new EmptyCell());
            }
        }

        if(!isOnlyEmptyCell){
            setCaseOnTheBoard(dragonCases, "Dragon");
            setCaseOnTheBoard(wizardCases, "Wizard");
            setCaseOnTheBoard(gobelinCases, "Gobelin");
            setCaseOnTheBoard(clubCases, "Club");
            setCaseOnTheBoard(swordCases, "Sword");
            setCaseOnTheBoard(flashCases, "Flash");
            setCaseOnTheBoard(fireballCases, "FireBall");
            setCaseOnTheBoard(bigPotionCases, "BigPotion");
            setCaseOnTheBoard(smallCases, "SmallPotion");
        }
    }

    /**
     * Updates the player's case position by adding the given number of cases.
     *
     * @param addCase the number of cases to move forward
     */
    public void addCaseOfGamer(int addCase) throws PersonnageHorsPlateauException {
        menu.showMessage("You move forward " + addCase + " cases");
        caseOfGamer += checkIfOutTheBoard(addCase);
        menu.showMessage("You arrived on case " + caseOfGamer + ", it's a " + casesList.get(caseOfGamer).toString() + " case.");

    }

    public int checkIfOutTheBoard(int addCase) throws PersonnageHorsPlateauException {
        if (addCase + caseOfGamer > casesList.toArray().length - 1) {
            throw new PersonnageHorsPlateauException("You are arrived on the last case.");
        }
        return addCase;
    }

    public void setPlayerToLastCell() {
        caseOfGamer = casesList.toArray().length - 1;
    }

    public void setPlayerToFirstCell() {
        caseOfGamer = 1;
    }
    /**
     * Returns the current case number of the player.
     *
     * @return the player's case number
     */
    public int getCaseOfGamer() {
        return caseOfGamer;
    }

    /**
     * Assigns bonus or enemy cases randomly on the board.
     *
     * @param nbCases the number of cases
     */
    private void setCaseOnTheBoard(int nbCases, String element) {
        Random rand = new Random();

        for (int i = 0; i < nbCases; i++) {
            Cell cell = getCellOfString(element);
            boolean isNotEmpty = true;
            while (isNotEmpty) {
                int randomCase = rand.nextInt(numberCase - 2) + 2;
                if (casesList.get(randomCase).isEmpty()) {
                    casesList.set(randomCase, cell);
                    isNotEmpty = false;
                }
            }
        }

    }

    public Cell getCaseOfPlayer() {
        return casesList.get(caseOfGamer);
    }

    public int getNumberCase() {
        return numberCase;
    }

    public void addCellToBoard(int index, Cell cell) {
        casesList.set(index, cell);
    }

    private Cell getCellOfString(String element) {
        return switch (element) {
            case "Dragon" -> new Dragon();
            case "Wizard" -> new Wizard();
            case "Gobelin" -> new Gobelin();
            case "Club" -> new Club();
            case "Sword" -> new Sword();
            case "FireBall" -> new FireBall();
            case "BigPotion" -> new BigPotion();
            case "SmallPotion" -> new SmallPotion();
            case "Flash" -> new Flash();
            default -> null;
        };
    }

    public void addCellToBoardWithIndex(int index, Gson gson, JsonObject json){
        if(json.get("cellType").getAsString().equals("FINAL")){
            casesList.set(index, gson.fromJson(json, FinalCell.class));
        }else if(!json.get("cellType").getAsString().equals("EMPTY")) {
            switch (json.get("name").getAsString()) {
                case "Dragon" -> casesList.set(index, gson.fromJson(json, Dragon.class));
                case "Wizard" -> casesList.set(index, gson.fromJson(json, Wizard.class));
                case "Gobelin" -> casesList.set(index, gson.fromJson(json, Gobelin.class));
                case "Club" -> casesList.set(index, gson.fromJson(json, Club.class));
                case "Sword" -> casesList.set(index, gson.fromJson(json, Sword.class));
                case "FireBall" -> casesList.set(index, gson.fromJson(json, FireBall.class));
                case "BigPotion" -> casesList.set(index, gson.fromJson(json, BigPotion.class));
                case "SmallPotion" -> casesList.set(index, gson.fromJson(json, SmallPotion.class));
                case "Flash" -> casesList.set(index, gson.fromJson(json, Flash.class));
            };
        }
    }
}
