package fr.campus.killthedragon.game;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.character.Mage;
import fr.campus.killthedragon.character.Warrior;
import fr.campus.killthedragon.equipement.Equipment;
import fr.campus.killthedragon.exception.PersonnageHorsPlateauException;
import fr.campus.killthedragon.db.DBConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Represents the main game logic and handles user interaction in the game.
 */
public class Game {
    private final Scanner scanner;
    private Character player;
    private final Board board;
    private final Menu menu;
    private final Dice dice;
    private DBConnection dataBase;

    public Game(Menu menu){
        scanner = new Scanner(System.in);
        board = new Board(64, 10, 10);
        this.menu = menu;
        dice = new Dice();
        dataBase = new DBConnection();
    }

    /**
     * Starts the game or allows the user to quit.
     * @return {@code true} if the player wants to restart; {@code false} to quit
     */
    public boolean playTurn(){
        String start = menu.getUserInput(scanner,"Enter y for start the game or any to quit the game.", null);
        if(start.equals("y")){
            menu.showMessage("Great let's start :)");

            String playerType = menu.getUserInput(scanner, "What is you favorite type, Warrior or Mage ?", new ArrayList<>(Arrays.asList("Warrior", "Mage")));
            String playerName = menu.getUserInput(scanner, "Enter your name : ", null);
            player = typeChoice(playerType, playerName);

            player = dataBase.createHero(player);
            String newName = menu.getUserInput(scanner, "Enter new name ", null);
            player = dataBase.editHero(player, newName);
            dataBase.changeLifePoints(player, 100);

            menu.showMessage("Welcome " + player + ". You start on the case " + board.getCaseOfGamer());

            while(board.getCaseOfGamer() < board.getNumberCase()){
                menu.getUserInput(scanner, "Press enter to roll the dice.", null);
                int diceRoll = dice.roll();

                try {
                    board.setCaseOfGamer(diceRoll);
                    Cell cellOfPlayer = board.getCaseOfPlayer();
                    switch (cellOfPlayer.getType()){
                        case BONUS :
                            Equipment equipment = (Equipment) cellOfPlayer;
                            player.setToInventory(equipment);
                            menu.showMessage("Inventory " + player.getInventory());
                            break;
                        case ENEMY:
                            menu.showMessage("The fight start against " + cellOfPlayer.getName());
                            break;
                    }
                }catch(PersonnageHorsPlateauException e){
                    menu.showMessage(e.getMessage());
                    enOfGame();
                }
            }
        }

        String restart = menu.getUserInput(scanner, "The game is end, press r to restart or any to quit.", null);
        return "r".equals(restart);
    }

    /**
     * Closes the scanner resource.
     */
    public void closeScanner(){
        scanner.close();
    }

    public Character typeChoice(String type, String name){
        if(type.equals("Mage")){
            return new Mage(name);
        } else {
            return new Warrior(name);
        }
    }

    public void enOfGame(){
        board.setPlayerToLastCell();
    }

}
