package fr.campus.killthedragon.game;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.game.Board;
import fr.campus.killthedragon.game.Menu;
import fr.campus.killthedragon.game.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Character player = null;
    private Board board = new Board();
    private Menu menu = new Menu();
    private Dice dice = new Dice();

    public boolean startOrQuit(){
        String start = menu.getUserInput(scanner,"Enter y for start the game or any to quit the game.", null);
        if(start.equals("y")){
            menu.showMessage("Great let's start :)");
            String playerType = menu.getUserInput(scanner, "What is you favorite type, Warrior or Mage ?", new ArrayList<>(Arrays.asList("Warrior", "Mage")));
            String playerName = menu.getUserInput(scanner, "Enter your name : ", null);
            player = new Character(playerType, playerName);
            menu.showMessage("Welcome " + player.toString());
            menu.showMessage("Inventory " + player.getInventory());

            menu.showMessage("You start on the case " + board.getCaseOfGamer());
            while(board.getCaseOfGamer() < 64){
                menu.getUserInput(scanner, "Press enter to roll the dice.", null);
                int diceRoll = dice.roll();
                menu.showMessage(String.valueOf(diceRoll));
                board.setCaseOfGamer(diceRoll);

            }
        }
        String restart = menu.getUserInput(scanner, "The game is end, press r to restart or any to quit.", null);

        return "r".equals(restart);
    }
    public void reset(){
        menu.showMessage("Do you want reset the game ?");
    }
    public void closeScanner(){
        scanner.close();
    }

}
