import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.game.Board;
import fr.campus.killthedragon.game.Game;
import fr.campus.killthedragon.game.Menu;
import fr.campus.killthedragon.db.CharacterDB;
import fr.campus.killthedragon.db.CellDB;

import java.util.List;

public class Main {

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

        String input = menu.getUserInput("Do you want reload the last save, y for yes or enter for no.", null);
        if(input.equals("y")){loadSave = true;}

        while(play){
            Game game = new Game(menu, loadSave);
            play = game.playTurn();
        }

        menu.closeScanner();
        menu.showMessage("Good bye :/");


    }
}
