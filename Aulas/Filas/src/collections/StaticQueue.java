package collections;

public class StaticQueue<E> implements Queue<E> {

    private ArrayList<E> queue;


    public StaticQueue(){
        queue = new ArrayList<>();
    }

    @Override
    public E dequeue() {        
        return queue.removeFirst();
    }

    @Override
    public void enqueue(E value) {
        queue.add(value);
        
    }

    @Override
    public E first() {
       
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {

        return queue.isEmpty();
    }

    @Override
    public int size() {
        
        return queue.size();
    }

    @Override
    public String toString() {
        
        return " first\n  \\/ \n"+queue.toString();
    }


    
    
}
