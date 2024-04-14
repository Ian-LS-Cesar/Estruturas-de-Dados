package collections;
import exceptions.EmptyListException;

public class LinkedList<E> implements List<E> {

    private class Node{
        E value;
        Node next;

        public Node(E value){
            this.value = value;
            next = null;
        }
        
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedList(){
        size = 0;
        head = newNode;
        tail = newNode;
        tail = null;
    }

    public LinkedList(E value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    @Override
    public void add(E value) {
        Node newNode = new Node(value);

        if()
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeLast() throws EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
