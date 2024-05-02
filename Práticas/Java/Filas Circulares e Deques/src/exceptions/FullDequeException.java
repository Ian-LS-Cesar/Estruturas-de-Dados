package exceptions;

public class FullDequeException extends RuntimeException {
    public FullDequeException(String errorMessage){
        super(errorMessage);
    }
}
