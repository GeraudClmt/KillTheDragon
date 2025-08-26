package fr.campus.killthedragon.game;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.game.Board;
import fr.campus.killthedragon.game.Menu;
import fr.campus.killthedragon.game.Dice;
import fr.campus.killthedragon.game.Case;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Represents the main game logic and handles user interaction in the game.
 */
public class Game {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the game or allows the user to quit.
     * @return {@code true} if the player wants to restart; {@code false} to quit
     */
    public boolean startOrQuit(){
        Board board = new Board(64, 10, 10);
        Menu menu = new Menu();
        Dice dice = new Dice();

        String start = menu.getUserInput(scanner,"Enter y for start the game or any to quit the game.", null);
        if(start.equals("y")){
            menu.showMessage("Great let's start :)");

            String playerType = menu.getUserInput(scanner, "What is you favorite type, Warrior or Mage ?", new ArrayList<>(Arrays.asList("Warrior", "Mage")));
            String playerName = menu.getUserInput(scanner, "Enter your name : ", null);
            Character player = new Character(playerType, playerName);

            menu.showMessage("Welcome " + player + ". You start on the case " + board.getCaseOfGamer());

            while(board.getCaseOfGamer() < board.getNumberCase()){
                menu.getUserInput(scanner, "Press enter to roll the dice.", null);
                int diceRoll = dice.roll();
                board.setCaseOfGamer(diceRoll);

                Case caseOfPlayer = board.getCaseOfPlayer();
                if(caseOfPlayer.getType() == Case.CellType.BONUS){
                    player.setToInventory(caseOfPlayer.getEquipment());
                    menu.showMessage("Inventory " + player.getInventory());
                } else if (caseOfPlayer.getType() == Case.CellType.ENEMY) {
                    menu.showMessage("The fight start against " + caseOfPlayer.getEnemy().getName());
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

}
