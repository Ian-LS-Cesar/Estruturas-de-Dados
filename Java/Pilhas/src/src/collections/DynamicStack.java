package collections;

import exceptions.EmptyStackException;

public class DynamicStack<E> implements Stack<E> {

    class Node{
        E value;
        Node next;
        public Node(E value){
            this.value = value;
        }
    }

    private int height;
    private Node top;


    public DynamicStack(){}
    public DynamicStack(E value){
        push(value);
    }

    @Override
    public int height() {        
        return height;
    }

    @Override
    public boolean isEmpty() {        
        return top==null;
    }

    @Override
    public E pop() {
        
        E value = top.value;
        top = top.next;
        height--;
        return value;
    }

    @Override
    public void push(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        height++;
        
    }

    @Override
    public E top() {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty");
        }
        return top.value;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Node auxNode = top;
        while(auxNode!=null){
            if(auxNode.next!=null){
                sb.append(auxNode.value+"\n");
                
            }else{
                sb.append(auxNode.value );

            }
            auxNode = auxNode.next;
        }
        return sb.toString();
    }

    

    

}
