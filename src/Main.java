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
        Menu menu = new Menu();
        Game game = new Game(menu);


        /*CharacterDB allCharacters = new CharacterDB();
        List<Character> listOfCharacter =  allCharacters.getHeroes();

        for (Character character : listOfCharacter){
            menu.showMessage(character.toString());
        }

        CellDB allCells = new CellDB();
        Board boardDB = allCells.getBoardOfPlayer("titi");*/


        menu.showMessage(
                "██   ██ ██ ██      ██          ████████ ██   ██ ███████     ██████  ██████   █████   ██████   ██████  ███    ██ \n" +
                "██  ██  ██ ██      ██             ██    ██   ██ ██          ██   ██ ██   ██ ██   ██ ██       ██    ██ ████   ██ \n" +
                "█████   ██ ██      ██             ██    ███████ █████       ██   ██ ██████  ███████ ██   ███ ██    ██ ██ ██  ██ \n" +
                "██  ██  ██ ██      ██             ██    ██   ██ ██          ██   ██ ██   ██ ██   ██ ██    ██ ██    ██ ██  ██ ██ \n" +
                "██   ██ ██ ███████ ███████        ██    ██   ██ ███████     ██████  ██   ██ ██   ██  ██████   ██████  ██   ████ \n" +
                "                                                                                                                \n" +
                "                                                                                                                ");

        while(play){
            game = new Game(menu);
            play = game.playTurn();
        }

        menu.closeScanner();
        menu.showMessage("Good bye :/");


    }
}
