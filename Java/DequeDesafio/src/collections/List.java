package collections;

public interface List<E> {
    void insert(E value);
    void add(E value);
    E removeFirst();
    E removeLast();
    E first();
    E last();
    boolean isEmpty();
    int size();

}
