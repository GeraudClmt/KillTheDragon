package fr.campus.killthedragon.game;

import fr.campus.killthedragon.Interfaces.DiceRollerInterface;

import java.util.Random;

/**
 * Represents a dice used in the game to generate a random roll.
 */
public class Dice implements DiceRollerInterface {
    private final Random random;

    public Dice(){
        random = new Random();
    }
    /**
     * Rolls the dice and returns a random value between 1 and the number of dice faces (inclusive).
     * @return the dice roll result
     */
    public int roll(int diceFaces) {
        return random.nextInt(diceFaces) + 1;
    }
}
