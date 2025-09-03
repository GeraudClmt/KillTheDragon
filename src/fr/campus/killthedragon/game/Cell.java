package fr.campus.killthedragon.game;

import fr.campus.killthedragon.character.Character;

/**
 * Represents a single cell on the game board.
 */
public abstract class Cell {
    protected CellType cellType;
    protected String name;

    public Cell(){
        name = null;
    }
    /**
     * Cell types for the board (empty, bonus, enemy, final).
     */
    public enum CellType{
        EMPTY,
        BONUS,
        ENEMY,
        FINAL,
    }
    /**
     * Checks if this cell is empty.
     * @return {@code true} if the case is EMPTY; {@code false} otherwise
     */
    public boolean isEmpty(){
        return cellType == CellType.EMPTY;
    }

    /**
     * Returns the name of the cell type as a string.
     * @return the cell type name
     */
    @Override
    public String toString(){
        return cellType.name();
    }

    public CellType interact(){
        return cellType;
    }

    public String getName(){
        return name;
    }

}
