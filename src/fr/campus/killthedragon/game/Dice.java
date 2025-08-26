package fr.campus.killthedragon.game;

import java.util.Random;

/**
 * Represents a dice used in the game to generate a random roll.
 */
public class Dice {
    private final Random random = new Random();

    /**
     * Rolls the dice and returns a random value between 1 and the number of dice faces (inclusive).
     * @return the dice roll result
     */
    public int roll(){
        return random.nextInt(6) + 1;
    }
}
