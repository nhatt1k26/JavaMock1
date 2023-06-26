package nhat.fpt.Mock1.exception;

public class FKMapNotExistException extends RuntimeException{
    public FKMapNotExistException(){}
    public FKMapNotExistException(String message) {
        super(message);
    }
}
