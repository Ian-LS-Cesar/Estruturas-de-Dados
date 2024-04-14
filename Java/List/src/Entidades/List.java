package Entidades;

import Exceptions.EmptyListException;

public interface List {
    int size();
    void add(int value);
    void insert(int value);
    void insert(int index, int value) throws IndexOutOfBoundsException;
    boolean isEmpty();
    int removeLast() throws EmptyListException;
    int removeFirst() throws EmptyListException;
    int removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException;
    void set(int index, int value) throws IndexOutOfBoundsException;
    int get(int index) throws IndexOutOfBoundsException;
    void clear();    
}
