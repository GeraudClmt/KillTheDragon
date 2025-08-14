package fr.campus.killthedragon.game;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.game.Board;
import fr.campus.killthedragon.game.Menu;
import fr.campus.killthedragon.game.Dice;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Character player = null;
    private Board board = null;
    private Menu menu = new Menu();
    private Dice dice = new Dice();

    public void startOrQuit(){
        String start = this.menu.getUserInput(this.scanner,"Start or quit the game ? y / n");
        if(start.equals("y")){
            menu.showMessage("Great let's start :)");
            String playerType = menu.getUserInput(scanner, "What is you favorite type, Warrior or Mage ?");
            String playerName = menu.getUserInput(scanner, "Enter your name : ");
            this.player = new Character(playerType, playerName);
            menu.showMessage("Welcome " + this.player.toString());
            menu.showMessage("Inventaire " + player.getInventory());

            menu.showMessage(String.valueOf(dice.roll()));
            //Don't forget to close the scanner !!!
            scanner.close();
        }else{
            menu.showMessage("Ok, see you :/");
        }
    }
    public void reset(){
        this.menu.showMessage("Do you want reset the game ?");
    }

}
