package Entidades;

import Exceptions.EmptyListException;
import Exceptions.FullListException;

public class StaticList implements List{

    private int size;
    private int[] staticList;
    private final int MAX_SIZE = 5;

    public StaticList(){
        staticList = new int[MAX_SIZE];
        size = 0;
    }

    @Override
    public void add(int value) {
       if (isFull()){
        throw new FullListException("Static List is Full!!");
       }
       staticList[size++] = value;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void insert(int value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insert(int index, int value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    @Override
    public int removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int removeFirst() throws EmptyListException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int removeLast() throws EmptyListException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void set(int index, int value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString(){
        String dados = "[";

        for(int i = 0; i < size; i++){
            if(i==size-1){
                dados = dados + staticList[i];
            }else{
                dados = dados + staticList[i] + ", ";
            }
        }

        return dados + "]";
    }
    
}
