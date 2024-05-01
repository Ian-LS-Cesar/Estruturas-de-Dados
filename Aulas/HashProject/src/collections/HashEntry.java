package collections;

public class HashEntry<K,V> implements Entry<K,V> {
    private K key;
    private V value;

    
    
    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public V getValue() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public void setValue(V value) {
        this.value = value;
    }
    
}
