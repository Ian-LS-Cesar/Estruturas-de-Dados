import collections.PriorityQueue;

import collections.Heap;

public class App {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer,String> heap = new Heap<>();
        heap.insert(5, "Mateus");
        heap.insert(10, "Gabriel");
        heap.insert(7, "Ian");
        heap.insert(10, "Sérgio");
        heap.insert(17, "Lívia");
        heap.insert(33, "Luana");
        heap.insert(46, "Pedro");
        heap.insert(1, "Ícaro");
        System.out.println(heap);
    }
}
