package fr.campus.killthedragon.game;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.exception.PersonnageIsDeadException;
import fr.campus.killthedragon.exception.PersonnageRunException;

public class FinalCell extends Cell{
    public FinalCell(){
        super.cellType = CellType.FINAL;
    }

    public void interact(Character player, Menu menu) throws PersonnageIsDeadException, PersonnageRunException {

    }
}
