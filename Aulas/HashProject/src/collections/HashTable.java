package collections;

public class HashTable<K,V> implements Map<K,V>{

    private Node<Entry<K,V>>[] hashTable;
    private int size;

    
    @SuppressWarnings("unchecked")
    public HashTable(int mapSize) {
        hashTable = new Node[mapSize];
    }

    @Override
    public Entry<K, V> delete(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry<K, V> get(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmnpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void put(K key, V value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
