package collections;

import exceptions.EmptyStackException;
import exceptions.FullStackException;

public class StaticStack<E> implements Stack<E> {

    private E[] stack;    
    private int height;

    @SuppressWarnings("unchecked")
    public StaticStack(){        
        stack = (E[])new Object[10];
    }

    @Override
    public int height() {        
        return height;
    }

    @Override
    public boolean isEmpty() {        
        return height==0;
    }

    public boolean isFull(){
        return height==stack.length;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty!");
        }
        height--;
        return stack[height];
    }

    @Override
    public void push(E value) {
        if(isFull()){
            throw new FullStackException("Stack is full!");
        }

        stack[height] = value;
        height++;
        
    }

    @Override
    public E top() {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty!");
        }
        return stack[height-1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = height-1; i >= 0; i--){
            sb.append(stack[i]+"\n");
        }
        return sb.toString();

    }

    

}
