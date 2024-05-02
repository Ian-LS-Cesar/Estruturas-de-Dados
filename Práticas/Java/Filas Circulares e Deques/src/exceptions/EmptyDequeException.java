package exceptions;

public class EmptyDequeException extends RuntimeException {
    public EmptyDequeException(String errorMessage){
        super(errorMessage);
    }
}
