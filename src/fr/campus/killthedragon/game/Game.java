package fr.campus.killthedragon.game;

import com.google.gson.*;
import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.character.Mage;
import fr.campus.killthedragon.character.Warrior;
import fr.campus.killthedragon.exception.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Represents the main game logic and handles user interaction in the game.
 */
public class Game {
    private Character player;
    private Board board;
    private final Menu menu;
    private final Dice dice;

    private final File dossierData;
    private final File filePlayer;
    private final File fileBoard;
    private final Gson gson;

    public Game(Menu menu, boolean loadSave) {
        this.menu = menu;
        dice = new Dice();
        gson = new Gson();
        dossierData = new File("data");
        filePlayer = new File(dossierData, "playerData.json");
        fileBoard = new File(dossierData, "boardData.json");
        if(loadSave){
            loadSaveState();
        }else{
            board = new Board(menu,64, 1, false);

        }
    }

    /**
     * Starts the game or allows the user to quit.
     *
     * @return {@code true} if the player wants to restart; {@code false} to quit
     */
    public boolean playTurn() {
        String start = menu.getUserInput("Enter y for start the game or any to quit the game.", null);
        if (start.equals("y")) {
            menu.showMessage("Great let's start :)");
            menu.printDragon();

            if(player == null){
                String playerType = menu.getUserInput("What is you favorite type, Warrior or Mage ?", new ArrayList<>(Arrays.asList("Warrior", "Mage")));
                String playerName = menu.getUserInput("Enter your name : ", null);
                player = typeChoice(playerType, playerName);
            }

            menu.showMessage("Welcome " + player + ". You start on the case " + board.getCaseOfGamer());

            while (board.getCaseOfGamer() < board.getNumberCase()) {
                menu.printDice();
                menu.getUserInput("\uD83C\uDFB2 Press enter to roll the dice.", null);
                int diceRoll = dice.roll();

                try {
                    board.addCaseOfGamer(diceRoll);

                    interactWithCell();


                } catch (PersonnageHorsPlateauException e) {
                    menu.showMessage(e.getMessage());
                    menu.showMessage("You win");
                    menu.printFinalDragon();
                    endOfGame();
                }

                if (player.getHealth() <= 0) {
                    endOfGame();
                    menu.showMessage("Game over !");
                    menu.prindDead();
                }
                saveGame();
            }
        }

        String restart = menu.getUserInput("The game is end, press r to restart or any to quit.", null);
        return "r".equals(restart);
    }

    public Character typeChoice(String type, String name) {
        if (type.equals("Mage")) {
            return new Mage(name);
        } else {
            return new Warrior(name);
        }
    }

    private void endOfGame() {
        board.setPlayerToLastCell();
    }

    private void run(){
        int randomInt = new Random().nextInt(6)+1;
        try{
            if(board.getCaseOfGamer() - randomInt <= 0){
                board.setPlayerToFirstCell();
            }else{
                board.addCaseOfGamer(-randomInt);
            }
        }catch (PersonnageHorsPlateauException e){
            menu.showMessage(e.getMessage());
        }
        interactWithCell();
    }

    private void interactWithCell(){
        Cell cellOfPlayer = board.getCaseOfPlayer();

        try{
            cellOfPlayer.interact(player, menu);
        } catch (PersonnageIsDeadException e) {
            menu.showMessage(e.getMessage());
            endOfGame();
        } catch (PersonnageRunException e) {
            menu.showMessage(e.getMessage());
            run();
        } catch (EnnemyIsAlreadyDeadException e) {
            menu.showMessage(e.getMessage());
        }
    }

    private void saveGame() {
        String playerJson = gson.toJson(player);
        String boardJson = gson.toJson(board);

        if (!dossierData.exists()) {
            if (!dossierData.mkdirs()) {
                menu.showMessage("Error can't create 'data'.");
                return;
            }
        }

        try (FileWriter writerPlayer = new FileWriter(filePlayer)) {
            writerPlayer.write(playerJson);
        } catch (IOException e) {
            menu.showMessage("Error : " + e.getMessage());
        }
        try (FileWriter writerBoard = new FileWriter(fileBoard)) {
            writerBoard.write(boardJson);
        } catch (IOException e) {
            menu.showMessage("Error : " + e.getMessage());
        }
    }

    private void loadSaveState(){

        try (BufferedReader reader = new BufferedReader(new FileReader(filePlayer))) {
            String line = reader.readLine();
                JsonObject lineJson = JsonParser.parseString(line).getAsJsonObject();
                if(lineJson.get("type").getAsString().equals("Mage")){
                    player = gson.fromJson(line, Mage.class);
                }else{
                    player = gson.fromJson(line, Warrior.class);
                }

            menu.showMessage("The player is correctly loaded.");
        } catch (NullPointerException e){
            menu.showMessage("The player save is empty.");
        }catch (IOException e) {
            System.out.println("Error for read the saved file.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileBoard))) {
            JsonObject lineJson  = JsonParser.parseString(reader.readLine()).getAsJsonObject();

            int numberCases = lineJson.get("numberCase").getAsInt();
            int caseOfGamer = lineJson.get("caseOfGamer").getAsInt();
            board = new Board(menu, numberCases, caseOfGamer, true);

            JsonArray casesArray = lineJson.getAsJsonArray("casesList");
            List<JsonObject> cellJsonObjects = new ArrayList<>();

            for (JsonElement elem : casesArray) {
                cellJsonObjects.add(elem.getAsJsonObject());
            }

            for(int i = 0; i < cellJsonObjects.size(); i++){
                board.addCellToBoardWithIndex(i, gson, cellJsonObjects.get(i));
            }

        menu.showMessage("The board is correctly loaded.");
        } catch (NullPointerException e){
            menu.showMessage("The board save is empty.");
            board = new Board(menu,64, 1, false);
        } catch (IOException e) {
            System.out.println("Error for read the saved file.");
        }
    }
}
