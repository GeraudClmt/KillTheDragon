package fr.campus.killthedragon.game;

import com.google.gson.Gson;
import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.character.Mage;
import fr.campus.killthedragon.character.Warrior;
import fr.campus.killthedragon.enemy.Enemy;
import fr.campus.killthedragon.equipement.Equipment;
import fr.campus.killthedragon.equipement.HealthEquipment;
import fr.campus.killthedragon.equipement.OffensiveEquipment;
import fr.campus.killthedragon.exception.*;
import fr.campus.killthedragon.db.CharacterDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents the main game logic and handles user interaction in the game.
 */
public class Game {
    private Character player;
    private final Board board;
    private final Menu menu;
    private final Dice dice;
    private CharacterDB dataBase;

    public Game(Menu menu) {
        board = new Board(64);
        this.menu = menu;
        dice = new Dice();
        dataBase = new CharacterDB();

    }

    /**
     * Starts the game or allows the user to quit.
     *
     * @return {@code true} if the player wants to restart; {@code false} to quit
     */
    public boolean playTurn() {
        String start = menu.getUserInput("Enter y for start the game or any to quit the game.", null);
        if (start.equals("y")) {
            menu.showMessage("Great let's start :)");
            menu.printDragon();

            String playerType = menu.getUserInput("What is you favorite type, Warrior or Mage ?", new ArrayList<>(Arrays.asList("Warrior", "Mage")));
            String playerName = menu.getUserInput("Enter your name : ", null);
            player = typeChoice(playerType, playerName);

            //player = dataBase.createHero(player);
            //String newName = menu.getUserInput("Enter new name ", null);
            //player = dataBase.editHero(player, newName);
            //dataBase.changeLifePoints(player, 10);
            //player = dataBase.getCharacter(player.getName());
            menu.showMessage("Welcome " + player + ". You start on the case " + board.getCaseOfGamer());

            while (board.getCaseOfGamer() < board.getNumberCase()) {
                saveGame();
                menu.printDice();
                menu.getUserInput("\uD83C\uDFB2 Press enter to roll the dice.", null);
                int diceRoll = dice.roll();

                try {
                    board.addCaseOfGamer(diceRoll);

                    interactWithCell();


                } catch (PersonnageHorsPlateauException e) {
                    menu.showMessage(e.getMessage());
                    menu.showMessage("You win");
                    menu.printFinalDragon();
                    endOfGame();
                }

                if (player.getHealth() <= 0) {
                    endOfGame();
                    menu.showMessage("Game over !");
                    menu.prindDead();
                }
            }
        }

        String restart = menu.getUserInput("The game is end, press r to restart or any to quit.", null);
        return "r".equals(restart);
    }

    public Character typeChoice(String type, String name) {
        if (type.equals("Mage")) {
            return new Mage(name);
        } else {
            return new Warrior(name);
        }
    }

    private void endOfGame() {
        board.setPlayerToLastCell();
    }

    private void run(){
        int randomInt = new Random().nextInt(6)+1;
        try{
            if(board.getCaseOfGamer() - randomInt <= 0){
                board.setPlayerToFirstCell();
            }else{
                board.addCaseOfGamer(-randomInt);
            }
        }catch (PersonnageHorsPlateauException e){
            menu.showMessage(e.getMessage());
        }
        interactWithCell();
    }

    private void interactWithCell(){
        Cell cellOfPlayer = board.getCaseOfPlayer();

        try{
            cellOfPlayer.interact(player, menu);
        } catch (PersonnageIsDeadException e) {
            menu.showMessage(e.getMessage());
            endOfGame();
        } catch (PersonnageRunException e) {
            menu.showMessage(e.getMessage());
            run();
        } catch (EnnemyIsAlreadyDeadException e) {
            menu.showMessage(e.getMessage());
        }
    }

    public void saveGame() {
        Gson gson = new Gson();
        String playerJson = gson.toJson(player);
        String boardJson = gson.toJson(board);

        File dossierData = new File("data");
        if (!dossierData.exists()) {
            if (!dossierData.mkdirs()) {
                menu.showMessage("Error can't create 'data'.");
                return;
            }
        }

        File filePlayer = new File(dossierData, "playerData.txt");
        File fileBoard = new File(dossierData, "boardData.txt");

        try (FileWriter writerPlayer = new FileWriter(filePlayer, true)) {
            writerPlayer.write(playerJson + "\n");
        } catch (IOException e) {
            menu.showMessage("Error : " + e.getMessage());
        }
        try (FileWriter writerBoard = new FileWriter(fileBoard, true)) {
            writerBoard.write(boardJson + "\n");
        } catch (IOException e) {
            menu.showMessage("Error : " + e.getMessage());
        }
    }

}
