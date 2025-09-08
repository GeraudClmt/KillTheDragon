package fr.campus.killthedragon.exception;

public class CriticalFailureException extends RuntimeException {
    public CriticalFailureException(String message) {
        super(message);
    }
}
