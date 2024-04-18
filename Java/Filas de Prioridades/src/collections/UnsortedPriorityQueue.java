package collections;

import javax.management.RuntimeErrorException;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    @Override
    public void insert(K key, V value) {
        Node newNode = new Node(key, value);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        size++;
    }

    private Node findMin() {
        Node minNode = last;
        Node auxNode = last.previous;

        while (auxNode != null) {
            int comp = compare(auxNode.entry, minNode.entry);
            if (comp == -1 || comp == 0) {
                minNode = auxNode;
            }

            auxNode = auxNode.previous;
        }

        return minNode;
    }

    @Override
    public Entry<K, V> maxPriority() {
        if (isEmpty())
            throw new RuntimeException("PQ is empty!");
        return findMin().entry;
    }

    @Override
    public Entry<K, V> remove() {
        if (isEmpty())
            throw new RuntimeException("PQ is empty!");
        Node minNode = findMin();

        if(size == 1){
            first = null;
            last = null;
        }else{
            if(minNode == first){
                System.out.println("removendo o primeiro");
                first = first.next;
                first.previous = null;
            }else if(minNode == last){
                System.out.println("removendo o último");
                last = last.previous;
                last.next = null;
            }else{
                System.out.println("removendo alguém entre primeiro e último");
                minNode.previous.next = minNode.next;
                minNode.next.previous = minNode.previous;
            }
        }
        size--;
        return minNode.entry;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
