package fr.campus.killthedragon.game;

import fr.campus.killthedragon.Interfaces.DiceRollerInterface;

import java.util.Random;

public class DiceCritical implements DiceRollerInterface {
    private final Random random;

    public DiceCritical(){
        random = new Random();
    }

    @Override
    public int roll(int diceFaces) {
        return random.nextInt(diceFaces) + 1;
    }
}
