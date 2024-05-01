package collections;

public class StaticDeque<E> implements Deque<E>{

    private int size;
    private E[] deque;
    private int first;

    @SuppressWarnings("unchecked")
    public StaticDeque(int maxSize){
        deque = (E[]) new Object[maxSize];
    }


    @Override
    public void add(E value) {
        if(isFull()){
            throw new RuntimeException("Deque is full!");
        }
        deque[(first + size)%deque.length] = value;
        size++; 
        
    }

    @Override
    public E first() {
        if(isEmpty()) throw new RuntimeException("Deque is empty!");
        return deque[first];
    }

    @Override
    public void insert(E value) {
        if(isFull())throw new RuntimeException("Deque is full!");
        first = (first - 1 + deque.length) % deque.length;
        deque[first] = value;
        size++;
        
    }

    public boolean isFull(){
        return size==deque.length;
    }
    @Override
    public boolean isEmpty() {        
        return size==0;
    }

    @Override
    public E last() {
        if(isEmpty()) throw new RuntimeException("Deque is empty!");
        return deque[(first - 1 + size)%deque.length];
    }

    @Override
    public E removeFirst() {
        if(isEmpty()) throw new RuntimeException("Deque is empty!");
        E value = first();
        size--;
        first = (first+1)%deque.length;
        return value;
    }

    @Override
    public E removeLast() {
        if(isEmpty()) throw new RuntimeException("Deque is empty!");
        E value = last();
        deque[(first-1+size)%deque.length] = null;        
        size--;
        return value;
    }

    @Override
    public int size() {        
        return size;
    }

    

}
