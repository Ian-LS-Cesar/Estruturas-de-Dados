public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> minhaLista = new DoublyLinkedList<>();
        
    }
}


//Exceptions
class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage){
        super(errorMessage);
    }
}


//TAD - List
interface List<E>{
    int size();
    void add(E value);
    void insert(E value);
    void insert(int index, E value) throws IndexOutOfBoundsException;
    boolean isEmpty();
    E removeLast() throws EmptyListException;
    E removeFirst() throws EmptyListException;
    E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException;
    void set(int index, E value) throws IndexOutOfBoundsException;
    E get(int index) throws IndexOutOfBoundsException;
    void clear();    
}

//LL - LinkedList



class DoublyLinkedList<E> implements List<E>{

    private class Node{
        E value;
        Node next;
        Node previous;
    
        public Node(E value){
            this.value = value;
            next = null;
            previous = null;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public DoublyLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    public DoublyLinkedList(E value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    @Override
    public void add(E value) { 
        Node newNode = new Node(value);   

        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;        
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {

        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        if(index>=size || index < 0){
            throw new IndexOutOfBoundsException("Illegal index "+index+". Legal indexes are [0 - "+(size-1)+"]");
        }
        
        return getNode(index).value;
    }

    @Override
    public void insert(E value) { // modificar
        Node newNode = new Node(value);

        if(isEmpty()){
            head = newNode;
            tail = newNode;            
        }else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
        
    }

    private Node getNode(int index){
        Node auxNode = head;
        int i = 0;
        while(i < index){
            auxNode = auxNode.next;
            i++;
        }
        return auxNode;
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException { // modificar
        
        if(index<=0){
            insert(value); //O(1)
        }else if(index>=size){
            add(value); //O(1)
        }else{
            Node newNode = new Node(value);
            Node auxNode = getNode(index);
            newNode.next = auxNode;
            newNode.previous = auxNode.previous;
            auxNode.previous.next = newNode;
            auxNode.previous = newNode;
            size++;
        }
        
    }

    @Override
    public boolean isEmpty() {
        
        return size==0;
    }

    @Override
    public E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {// modificar
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        if(index>=size || index < 0){
            throw new IndexOutOfBoundsException("Illegal index "+index+". Legal indexes are [0 - "+(size-1)+"]");
        }
        E value = null;
        if(index == 0){
            value = removeFirst();
        }else if(index == size-1){
            value = removeLast();
        }else{
            Node auxNode = getNode(index);
            auxNode.previous.next = auxNode.next;
            auxNode.next.previous = auxNode.previous;
            // auxNode.next = null;
            // auxNode.previous = null;
            size--;
        }
        return value;
    }

    @Override
    public E removeLast() throws EmptyListException { // modificar
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        E value = tail.value;
        if(size==1){
            head = null;
            tail = null;
        }else{
            tail = tail.previous;
            // tail.next.previous = null;
            tail.next = null;           
            
        }
        size--;

        return value;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        Node auxNode = head;
        if(size==1){
            head = null;
            tail = null;
        }else{
            head = auxNode.next;            
            head.previous = null;
            auxNode.next = null;
        }

        size--;
        return auxNode.value;
    }

   

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException,EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        if(index>=size || index < 0){
            throw new IndexOutOfBoundsException("Illegal index "+index+". Legal indexes are [0 - "+(size-1)+"]");
        }

        getNode(index).value = value;
        
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");        
        Node auxNode = head;
        while(auxNode!=null){
            sb.append(auxNode.value);
            if(auxNode.next != null){
                sb.append(", ");
            }
            auxNode = auxNode.next;
        }
        return sb.append("]").toString();
    }

    public String reverseString(){
        StringBuilder sb = new StringBuilder("[");        
        Node auxNode = tail;
        while(auxNode!=null){
            sb.append(auxNode.value);
            if(auxNode.previous != null){
                sb.append(", ");
            }
            auxNode = auxNode.previous;
        }
        return sb.append("]").toString();
    }


    
    
}



