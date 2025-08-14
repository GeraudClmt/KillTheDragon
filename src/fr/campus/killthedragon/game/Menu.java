package fr.campus.killthedragon.game;

import java.util.Scanner;

public class Menu {

    public String getUserInput(Scanner scanner, String question){
        this.showMessage(question);
        return scanner.nextLine();
    }
    public void showMessage(String message){
        System.out.println((message));
    }
}
