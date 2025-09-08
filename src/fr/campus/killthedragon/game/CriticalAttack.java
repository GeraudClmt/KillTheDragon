package fr.campus.killthedragon.game;

import fr.campus.killthedragon.exception.CriticalAttackException;
import fr.campus.killthedragon.exception.CriticalFailureException;

public class CriticalAttack {
    private final DiceCritical diceCritical;

    public CriticalAttack(){
        diceCritical = new DiceCritical();
    }

    public void getCritical(int diceFaces) throws CriticalAttackException, CriticalFailureException {
        int criticalStrike = diceCritical.roll(diceFaces);
        System.out.println(criticalStrike);
        if(criticalStrike==1){
            throw new CriticalFailureException("It's a critical failure!");
        }else if (criticalStrike==diceFaces) {
            throw new CriticalAttackException("It's a critical attack!");
        }
    }
}
