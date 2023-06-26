package nhat.fpt.Mock1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage entityNotFoundException(EntityNotFoundException e, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        return message;
    }

    @ExceptionHandler(value = {UsernameExistedException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage entityNotFoundException(UsernameExistedException e, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        return message;
    }
    @ExceptionHandler(value = {FKMapNotExistException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage entityNotFoundException(FKMapNotExistException e, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        return message;
    }
}
