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
        String start = this.menu.getUserInput(this.scanner,"Enter y for start the game or any to quit the game.", null);
        if(start.equals("y")){
            this.menu.showMessage("Great let's start :)");
            String playerType = this.menu.getUserInput(this.scanner, "What is you favorite type, Warrior or Mage ?", new ArrayList<>(Arrays.asList("Warrior", "Mage")));
            String playerName = this.menu.getUserInput(this.scanner, "Enter your name : ", null);
            this.player = new Character(playerType, playerName);
            this.menu.showMessage("Welcome " + this.player.toString());
            this.menu.showMessage("Inventory " + this.player.getInventory());

            this.menu.showMessage("You start on the case " + this.board.getCaseOfGamer());
            while(board.getCaseOfGamer() < 64){
                this.menu.getUserInput(this.scanner, "Press enter to roll the dice.", null);
                int diceRoll = this.dice.roll();
                this.menu.showMessage(String.valueOf(diceRoll));
                this.board.setCaseOfGamer(diceRoll);

            }
        }
        String restart = this.menu.getUserInput(this.scanner, "The game is end, press r to restart or any to quit.", null);

        return "r".equals(restart);
    }
    public void reset(){
        this.menu.showMessage("Do you want reset the game ?");
    }
    public void closeScanner(){
        this.scanner.close();
    }

}
