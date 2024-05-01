package collections;

public class Heap<K,V> extends AbstractHeap<K,V> {

    @Override
    public void insert(K key, V value) {
        Entry<K,V> newEntry = new HeapEntry(key, value);
        heap.add(newEntry);

        int current = heap.size()-1;    
        int parent = parent(current);
        //bubbling up
        while(current > 0 && compare(current, parent)==-1){
            swap(current, parent);
            current = parent;
            parent = parent(current);
        }
        
    }

    private void swap(int index1, int index2){
        Entry<K,V> auxEntry = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2,auxEntry);
    }

    private int parent(int child){
        return (child-1)/2;
    }

    private int rightChild(int parent){
        return leftChild(parent)+1;
    }

    private int leftChild(int parent){
        return (parent*2)+1;
    }

    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new RuntimeException("Heap is empty!");
        return heap.get(0);
    }

    @Override
    public Entry<K, V> remove() {
        if(isEmpty()) throw new RuntimeException("Heap is empty!");

        Entry<K,V> entry;

        if(size()==1){
            entry = heap.removeLast();
        }else{
            entry = heap.get(0);
            heap.set(0,heap.removeLast());
            sinkDown();
        }
        return entry;
    }

    private void sinkDown(){
        int current;
        int minIndex = 0;
        int leftChild, rightChild;

        do{
            current = minIndex;
            leftChild = leftChild(current);
            rightChild = rightChild(current);

            if(leftChild < size() && compare(leftChild,minIndex )==-1){
                minIndex = leftChild;
            }

            if(rightChild < size() && compare(rightChild, minIndex)==-1){
                minIndex = rightChild;                
            }

            if(minIndex!=current){
                swap(current, minIndex);
            }

        }while(minIndex!=current);
    }

    

}
