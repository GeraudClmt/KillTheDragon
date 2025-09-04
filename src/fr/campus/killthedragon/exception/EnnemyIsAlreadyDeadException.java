package fr.campus.killthedragon.exception;

public class EnnemyIsAlreadyDeadException extends RuntimeException {
    public EnnemyIsAlreadyDeadException(String message) {
        super(message);
    }
}
