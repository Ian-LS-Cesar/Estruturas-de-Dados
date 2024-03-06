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
        if(isFull()){
            throw new FullListException("Static List is Full");
        }
        
        for (int i = size; i > 0; i--){
            staticList[i] = staticList[i - 1];
        }
        
        staticList[0] = value;
        size++;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= MAX_SIZE);
        throw new IndexOutOfBoundsException("Index " + index + " is invalid");
    }
    @Override
    public void insert(int index, int value) {
        if(isFull()){
            throw new FullListException("Static List is Full");
        }
        checkIndex(index);

        if (index>=size){
            add(value);
        }else{
            for (int i = size; i > index; i--){
                staticList[i] = staticList[i - 1];
            }
            staticList[index] = value;
            size++;
            
        }

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
        if(isEmpty()){
            throw new EmptyListException("Empty List Exception");
        }
        int value = staticList[0];
        for(int i = 0; i < size - 1; i++){
            staticList[i] = staticList[i+1];
        }
        size--;
        return value;
    }

    @Override
    public int removeLast() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Empty List Exception");
        }

        return staticList[--size];
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
