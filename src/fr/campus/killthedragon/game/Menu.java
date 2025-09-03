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

    public void printDragon(){
        showMessage("                \\||/\n" +
                "                |  @___oo\n" +
                "      /\\  /\\   / (__,,,,|\n" +
                "     ) /^\\) ^\\/ _)\n" +
                "     )   /^\\/   _)\n" +
                "     )   _ /  / _)\n" +
                " /\\  )/\\/ ||  | )_)\n" +
                "<  >      |(,,) )__)\n" +
                " ||      /    \\)___)\\\n" +
                " | \\____(      )___) )___\n" +
                "  \\______(_______;;; __;;;");
    }
    public void printDice(){
        showMessage("    _______            \n" +
                "  /\\       \\           \n" +
                " /()\\   ()  \\          \n" +
                "/    \\_______\\         \n" +
                "\\    /()     /         \n" +
                " \\()/   ()  /          \n" +
                "  \\/_____()/\n");
    }
    public void printChest(){
        showMessage("\n" +
                "                            _.--.\n" +
                "                        _.-'_:-'||\n" +
                "                    _.-'_.-::::'||\n" +
                "               _.-:'_.-::::::'  ||\n" +
                "             .'`-.-:::::::'     ||\n" +
                "            /.'`;|:::::::'      ||_\n" +
                "           ||   ||::::::'     _.;._'-._\n" +
                "           ||   ||:::::'  _.-!oo @.!-._'-.\n" +
                "           \\'.  ||:::::.-!()oo @!()@.-'_.|\n" +
                "            '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n" +
                "              `>'-.!@%()@'@_%-'_.-o _.|'||\n" +
                "               ||-._'-.@.-'_.-' _.-o  |'||\n" +
                "               ||=[ '-._.-\\U/.-'    o |'||\n" +
                "               || '-.]=|| |'|      o  |'||\n" +
                "               ||      || |'|        _| ';\n" +
                "               ||      || |'|    _.-'_.-'\n" +
                "               |'-._   || |'|_.-'_.-'\n" +
                "            jgs '-._'-.|| |' `_.-'\n" +
                "                    '-.||_/.-'");
    }
    public void printGobelin(){
        showMessage("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠢⣤⣀⡀⠀⠀⠀⢿⣧⣄⡉⠻⢿⣿⣿⡿⠟⢉⣠⣼⡿⠀⠀⠀⠀⣀⣤⠔⠀\n" +
                "⠀⠀⠈⢻⣿⣶⠀⣷⠀⠉⠛⠿⠶⡴⢿⡿⢦⠶⠿⠛⠉⠀⣾⠀⣶⣿⡟⠁⠀⠀\n" +
                "⠀⠀⠀⠀⠻⣿⡆⠘⡇⠘⠷⠠⠦⠀⣾⣷⠀⠴⠄⠾⠃⢸⠃⢰⣿⠟⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠋⢠⣾⣥⣴⣶⣶⣆⠘⣿⣿⠃⣰⣶⣶⣦⣬⣷⡄⠙⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢋⠛⠻⠿⣿⠟⢹⣆⠸⠇⣰⡏⠻⣿⠿⠟⠛⡙⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠈⢧⡀⠠⠄⠀⠈⠛⠀⠀⠛⠁⠀⠠⠄⢀⡼⠁⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠈⢻⣦⡀⠃⠀⣿⡆⢰⣿⠀⠘⢀⣴⡟⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣦⡀⠘⠇⠸⠃⢀⣴⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣿⣷⣄⣠⣾⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }
    public void printWizard(){
        showMessage("              _,-'|\n" +
                "           ,-'._  |\n" +
                " .||,      |####\\ |\n" +
                "\\.`',/     \\####| |\n" +
                "= ,. =      |###| |\n" +
                "/ || \\    ,-'\\#/,'`.\n" +
                "  ||     ,'   `,,. `.\n" +
                "  ,|____,' , ,;' \\| |\n" +
                " (3|\\    _/|/'   _| |\n" +
                "  ||/,-''  | >-'' _,\\\\\n" +
                "  ||'      ==\\ ,-'  ,'\n" +
                "  ||       |  V \\ ,|\n" +
                "  ||       |    |` |\n" +
                "  ||       |    |   \\\n" +
                "  ||       |    \\    \\\n" +
                "  ||       |     |    \\\n" +
                "  ||       |      \\_,-'\n" +
                "  ||       |___,,--\")_\\\n" +
                "  ||         |_|   ccc/\n" +
                "  ||        ccc/\n" +
                "  ||                ");
    }
}
