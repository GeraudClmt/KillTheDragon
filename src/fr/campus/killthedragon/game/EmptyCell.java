package fr.campus.killthedragon.game;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.exception.PersonnageIsDeadException;
import fr.campus.killthedragon.exception.PersonnageRunException;

public class EmptyCell extends Cell{

    public EmptyCell(){
        super.cellType = CellType.EMPTY;
    }

    public void interact(Character player, Menu menu) throws PersonnageIsDeadException, PersonnageRunException{

    }
}
