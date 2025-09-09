import fr.campus.killthedragon.game.Game;
import fr.campus.killthedragon.game.Menu;

/**
 * Entry point for the KillTheDragon application.
 */
public class Main {

    /**
     * Starts the application and the main game loop.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        boolean play = true;
        boolean loadSave = false;
        Menu menu = new Menu();

        menu.showMessage(
                "██   ██ ██ ██      ██          ████████ ██   ██ ███████     ██████  ██████   █████   ██████   ██████  ███    ██ \n" +
                "██  ██  ██ ██      ██             ██    ██   ██ ██          ██   ██ ██   ██ ██   ██ ██       ██    ██ ████   ██ \n" +
                "█████   ██ ██      ██             ██    ███████ █████       ██   ██ ██████  ███████ ██   ███ ██    ██ ██ ██  ██ \n" +
                "██  ██  ██ ██      ██             ██    ██   ██ ██          ██   ██ ██   ██ ██   ██ ██    ██ ██    ██ ██  ██ ██ \n" +
                "██   ██ ██ ███████ ███████        ██    ██   ██ ███████     ██████  ██   ██ ██   ██  ██████   ██████  ██   ████ \n" +
                "                                                                                                                \n" +
                "                                                                                                                ");

        String input = menu.getUserInput("Do you want load the last save, y for yes or enter", null);
        if(input.equals("y")){loadSave = true;}

        while(play){
            Game game = new Game(menu, loadSave);
            play = game.playTurn();
            loadSave = false;
        }

        menu.closeScanner();
        menu.showMessage("Good bye :/");
    }


}
