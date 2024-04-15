package collections;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    E first();
    boolean isEmpty();
    int size();
}
