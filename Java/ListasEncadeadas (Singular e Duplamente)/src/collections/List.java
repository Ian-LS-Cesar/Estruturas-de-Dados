package collections;

import exceptions.EmptyListException;

public interface List<E> {
    int size();
    void add(E value);
    void insert(E value);
    void insert(int index, E value) throws IndexOutOfBoundsException;
    boolean isEmpty();
    E removeLast() throws EmptyListException;
    E removeFirst() throws EmptyListException;
    E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException;
    E get(int index) throws IndexOutOfBoundsException;
    void set(int index, E value) throws EmptyListException, IndexOutOfBoundsException;
    void clear();
}
