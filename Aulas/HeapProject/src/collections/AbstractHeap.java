package collections;

import java.util.Comparator;

import entidades.ArrayList;
import entidades.DefaultComparator;
import entidades.List;

public abstract class AbstractHeap<K,V> implements PriorityQueue<K,V> {

    class HeapEntry implements Entry<K,V>{

        K key;
        V value;

        public HeapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {            
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + " - " + value + ")";
        }
    }


    protected List<Entry<K,V>> heap;
    private Comparator<K> comparator;

    public AbstractHeap(){
        comparator = new DefaultComparator<>();
        heap = new ArrayList<>();
    }

    public int compare(int index1, int index2){
        return compare(heap.get(index1), heap.get(index2));
    }

    public int compare(Entry<K,V> e1, Entry<K,V> e2){
        return comparator.compare(e1.getKey(), e2.getKey());
    }


    @Override
    public boolean isEmpty() {        
        return heap.isEmpty();
    }


    @Override
    public int size() {        
        return heap.size();
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    

}
