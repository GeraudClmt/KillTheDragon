package fr.campus.killthedragon.exception;

public class AlreadyToInventoryException extends RuntimeException {
    public AlreadyToInventoryException(String message) {
        super(message);
    }
}
