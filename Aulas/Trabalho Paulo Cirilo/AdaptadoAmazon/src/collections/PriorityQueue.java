package collections;

public interface PriorityQueue<K,V> {
    void insert(K key, V value);
    Entry<K,V> maxPriority();
    Entry<K,V> remove();
    boolean isEmpty();
    int size();

}
