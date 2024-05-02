package exceptions;

public class EmptyPriorityQueueException extends RuntimeException {
    public EmptyPriorityQueueException(String errorMessage){
        super(errorMessage);
    }
}
