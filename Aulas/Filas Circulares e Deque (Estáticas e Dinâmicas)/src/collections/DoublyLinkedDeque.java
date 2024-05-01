package collections;

import java.nio.channels.ScatteringByteChannel;

public class DoublyLinkedDeque<E> implements Deque<E> {
    class Node{
        Node next;
        Node prev;
        E value;
        public Node(E value) {
            this.value = value;
        }
        
    }

    Node first;
    Node last;
    int size;



    @Override
    public void add(E value) {        
        Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;
        }else{
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;        
    }

    @Override
    public E first() {
        if(isEmpty()) throw new RuntimeException("Deque is empty!");
        return first.value;
    }

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            last = newNode;
        }else{
            newNode.next = first;
            first.prev = newNode;
        }
        first = newNode;
        size++;
        
    }

    @Override
    public boolean isEmpty() {        
        return size == 0;
    }

    @Override
    public E last() {
        if(isEmpty()) throw new RuntimeException("Deque is empty!");
        return last.value;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()) throw new RuntimeException("Deque is empty!");
        E value = first();

        if(size==1){
            first = null;
            last = null;
        }else{
            first.next.prev = null;
            first = first.next;
        }
        size--;
        return value;
    }

    @Override
    public E removeLast() {
        if(isEmpty()) throw new RuntimeException("Deque is empty!");
        E value = last();
        if(size==1){
            first = null;
            last = null;
        }else{
            last = last.prev;
            last.next = null;
        }
        size--;
        return value;
    }

    @Override
    public int size() {
        
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node auxNode = first;

        while(auxNode!=null){
            sb.append(auxNode.value);
            if(auxNode.next!=null){
                sb.append(", ");
            }

            auxNode = auxNode.next;
        }

        sb.append("]");
        return sb.toString();
    }

    

    
}
