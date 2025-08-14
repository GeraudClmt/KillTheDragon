package fr.campus.killthedragon.game;

import java.util.Random;

public class Dice {
    private int diceFace = 6;
    private Random random = new Random();

    public int roll(){
        return random.nextInt(diceFace) + 1;
    }
}
