package collections;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    @Override
    public void insert(K key, V value) {
        Node newNode = new Node(key,value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            if(compare(newNode.entry, first.entry)<0){
                newNode.next = first;
                first.previous = newNode;
                first = newNode;
            }else if(compare(newNode.entry, last.entry)>=0){
                last.next = newNode;
                newNode.previous = last;
                last = newNode;
            }else{
                Node auxNode = first;
                while(compare(newNode.entry, auxNode.entry)>=0){
                    auxNode = auxNode.next;
                }
                newNode.next = auxNode;
                newNode.previous = auxNode.previous;
                auxNode.previous.next = newNode;
                auxNode.previous = newNode;

            }
        }
        size++;        
    }

    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new RuntimeException("PQ is empty");
        return first.entry;
    }
    
    @Override
    public Entry<K, V> remove() {
        if(isEmpty()) throw new RuntimeException("PQ is empty");
        Entry<K,V> entry = first.entry;
        if(size==1){
            first = null;
            last = null;
        }else{
            first = first.next;
            first.previous = null;
        }
        size--;
        return entry;
    }

    

}
