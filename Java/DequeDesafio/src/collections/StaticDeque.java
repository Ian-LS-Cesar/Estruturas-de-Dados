package collections;
import exceptions.EmptyDequeException;
import exceptions.FullDequeException;

public class StaticDeque<E> implements Deque<E> {

    private E[] deque;
    private int size;
    private int first;

    public StaticDeque(int maxSize){
        deque = (E[]) new Object[maxSize];
    }
    @Override
    public void add(E value) {
        if (isFull()){
            throw new FullDequeException("Deque is Full!!!");
        }
        deque[(first + size)% deque.length] = value;
        size++;
    }

    @Override
    public void insert(E value) {
        if (isFull()){
            throw new FullDequeException("Deque is Full!!!");
        }
        first = (first - 1 + deque.length)%deque.length;
        deque[first] = value;
        size++;
        
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            throw new EmptyDequeException("Deque is Empty!!1");
        }
        E value = deque[first];
        deque[first] = null;
        size--;
        first = (first+1)%deque.length;
        return value;
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            throw new EmptyDequeException("Deque is Empty!!!");
        }
        E value = last();
        deque[(first + size)% deque.length] = null;
        size --;
        return value;
        
    }
    @Override
        public E first() {
            if(isEmpty()){
                throw new EmptyDequeException("Deque is Empty!!1");
            }
            return deque[first];
        }
    @Override
    public E last() {
        if(isEmpty()){
            throw new EmptyDequeException("Deque is Empty!!1");
        }

        return deque[(first + size)% deque.length];
    }

    @Override
    public int size() {
        return size();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < size; i++){
            sb.append(deque[(first+i)%deque.length]);
            if(i!=size-1){
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
    

}
