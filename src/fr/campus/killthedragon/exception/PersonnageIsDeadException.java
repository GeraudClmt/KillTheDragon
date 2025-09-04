package fr.campus.killthedragon.exception;

public class PersonnageIsDeadException extends RuntimeException {
    public PersonnageIsDeadException(String message) {
        super(message);
    }
}
