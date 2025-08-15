package exceptions;

public class ContactAlreadyExistException extends Exception {
    public ContactAlreadyExistException(String message) {
        super(message);
    }
}
