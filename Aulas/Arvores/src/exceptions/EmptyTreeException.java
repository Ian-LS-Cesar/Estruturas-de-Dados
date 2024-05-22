package exceptions;

public class EmptyTreeException extends RuntimeException {
    public EmptyTreeException(String errorMessage){
        super(errorMessage);
    }
}
