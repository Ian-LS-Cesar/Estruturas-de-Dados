import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //ArrayList<Integer> minhaLista = new ArrayList<Integer>();
        //Node<Integer> meuNo = new Node<Integer>(3);
        LinkedList<Integer> minhaLista = new LinkedList<>(99);

        minhaLista.add(2);
        minhaLista.add(5);
    }
}

//Exceptions
class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage){
    }
}

//TAD - List (Tipo Abstrato de Dados)
interface List<E> {
    int size();
    void add(E value);
    void insert(E value);
    void insert(int index, E value);
    boolean isEmpty();
    E removeLast() throws EmptyListException;
    E removeFirst() throws EmptyListException;
    E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException;
    void set(int index, E value) throws IndexOutOfBoundsException;
    E get(int index) throws IndexOutOfBoundsException;
    void clear();
}

//LL - Linked List


class LinkedList<E> implements List<E>{
    
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
        head = null;
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

        if (isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            //tail.next = newNode;
            tail = newNode;
        }
        size++;
        
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
    public void insert(int index, E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        
        return size == 0;
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
    public void set(int index, E value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        String linkedList = "[";

        Node auxNode = head;
        while (auxNode != null){
            if (auxNode.next == null){
                linkedList += auxNode.value;
            } else {
                linkedList += auxNode.value + ", ";
            }

            auxNode = auxNode.next;
        }

        return linkedList + "]";
    }
    
    
}
