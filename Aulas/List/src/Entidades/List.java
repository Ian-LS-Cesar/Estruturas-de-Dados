package Entidades;

import Exceptions.EmptyListException;

public interface List {
    int size();
    void add(int value);
    void insert(int value);
    void insert(int index, int value) throws IndexOutOfBoundsException;
    boolean isEmpty();
    int removeFirst() throws EmptyListException;
    int removeLast() throws EmptyListException;
    int removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException;
    int get(int index) throws IndexOutOfBoundsException;
    void set(int index, int value) throws IndexOutOfBoundsException;
    void clear();
}
