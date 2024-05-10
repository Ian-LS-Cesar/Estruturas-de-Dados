import collections.Heap;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Heap<Integer,String> heap = new Heap<>();

        Heap<Integer,String> heapMaiores = new Heap<>();
        Scanner leitor = new Scanner(System.in);
        int k = leitor.nextInt();

        heap.insert(7,"x");
        heap.insert(10,"y");
        heap.insert(4,"z");
        heap.insert(3,"w");
        heap.insert(20,"j");
        heap.insert(15,"q");

        for(int i = 0; i < k; i++){
            heap.maxPriority();
            heapMaiores.insert(heap.maxPriority().getKey(),heap.maxPriority().getValue());
            heap.remove(heap.maxPriority());
        }
        
        System.out.println(heap.maxPriority());
    }
}
