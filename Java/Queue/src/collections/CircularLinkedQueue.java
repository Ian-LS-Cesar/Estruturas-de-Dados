package collections;

public class CircularLinkedQueue<E> implements Queue<E>{

    class Node{
        E value;
        Node next;
        public Node(E value) {
            this.value = value;
        }
        
    }

    private int size;
    private Node first;
    private Node last;

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Circular Queue is empty!");            
        }
        E value = first();
        if(size==1){
            first = null;
            last = null;            
        }else{
            first = first.next;
            last.next = first;
        }
        size--;
        return value;
    }

    public void rotate(){
        last = last.next;
        first = first.next;
    }

    @Override
    public void enqueue(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;            
        }else{
            last.next = newNode;
        }
        last = newNode;
        last.next = first;
        size++;
        
    }

    @Override
    public E first() {
        if(isEmpty()){
            throw new RuntimeException("Circular Queue is empty!");
        }
        return first.value;
    }

    @Override
    public boolean isEmpty() {        
        return last==null;
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node auxNode =  first;
        for(int i = 0; i < size; i++){
            sb.append(auxNode.value);
            if(i!=size-1){
                sb.append(", ");
            }
            auxNode = auxNode.next;
        }

        sb.append("]");
        return sb.toString();
    }
    
    

}
