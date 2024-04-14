package collections;
import exceptions.EmptyStackException;
import exceptions.FullStackException;

public class StaticQueue<E> implements Queue<E> {

    private E[] queue;
    private int size;

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new EmptyStackException("Queue is empty!");
        }
    }

    @Override
    public void enqueue(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E first(E value) {
        if(isEmpty()){
            throw new EmptyStackException("Queue is empty!");
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

}
