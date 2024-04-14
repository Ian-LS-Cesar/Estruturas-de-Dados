package collections;

public class CircularStaticQueue<E> implements Queue<E> {

    private E[] queue;
    private int size;
    private int first;

    public CircularStaticQueue(int maxSize){
        queue = (E[]) new Object[maxSize];
        size = 0;
        first = 0;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Circular Queue is empty!");
        }
        E value = queue[first];
        queue[first] = null;
        size--;
        first = (first+1)%queue.length;
        return value;
    }


    @Override
    public void enqueue(E value) {
        if(isFull()){
            throw new RuntimeException("Circular Queue is full!");
        }

        
        queue[(first + size)%queue.length] = value;
        size++;

        
    }

    

    @Override
    public E first() {
        if(isEmpty()){
            throw new RuntimeException("Circular Queue is empty!");
        }
        return queue[first];
    }

    public boolean isFull(){
        return size==queue.length;
    }

    @Override
    public boolean isEmpty() {
        
        return size==0;
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < size; i++){
            sb.append(queue[(first+i)%queue.length]);
            if(i!=size-1){
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    

    

}
