package nhat.fpt.Mock1.exception;

public class UsernameExistedException extends RuntimeException{
    public UsernameExistedException() {

    }

    public UsernameExistedException(String message) {
        super(message);
    }
}
