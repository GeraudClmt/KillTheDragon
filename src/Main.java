import fr.campus.killthedragon.game.Game;
import fr.campus.killthedragon.game.Menu;
import fr.campus.killthedragon.db.CharacterDB;

public class Main {

    public static void main(String[] args) {
        CharacterDB allCharacters = new CharacterDB();
        allCharacters.getHeroes();

        boolean play = true;
        Menu menu = new Menu();
        Game game = new Game(menu);

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

        game.closeScanner();
        menu.showMessage("Good bye :/");


    }
}
