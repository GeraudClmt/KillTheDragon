package fr.campus.killthedragon.game;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles user input and displaying messages in the console menu.
 */
public class Menu {

    /**
     * Gets user input from the console after displaying a question, with optional value checking.
     * @param scanner the scanner to read input
     * @param question the question to prompt the user
     * @param correctValue the list of accepted values (can be null for no check)
     * @return the user's input string
     */
    public String getUserInput(Scanner scanner, String question, ArrayList<String> correctValue){
        while(true){
            showMessage(question);
            String input = scanner.nextLine();

            if(correctValue == null || correctValue.contains(input)){
                return input;
            }
            showMessage("Error of input, please try again.");
        }

    }

    /**
     * Displays the given message to the console.
     * @param message the message to display
     */
    public void showMessage(String message){
        System.out.println((message));
    }
}
