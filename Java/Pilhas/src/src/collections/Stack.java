package collections;

public interface Stack<E> {
    int height();
    void push(E value);
    E pop();
    E top();
    boolean isEmpty();
}
