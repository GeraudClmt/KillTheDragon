package fr.campus.killthedragon.game;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public String getUserInput(Scanner scanner, String question, ArrayList<String> correctValue){
        while(true){
            this.showMessage(question);
            String input = scanner.nextLine();

            if(correctValue == null || correctValue.contains(input)){
                return input;
            }
            this.showMessage("Error of input, please try again.");
        }

    }
    public void showMessage(String message){
        System.out.println((message));
    }
}
