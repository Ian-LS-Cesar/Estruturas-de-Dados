import collections.SortedPriorityQueue;
import collections.UnsortedPriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        SortedPriorityQueue<Integer,String> filaPrioridade = new SortedPriorityQueue<>();

        filaPrioridade.insert(0, "Gabriel");
        filaPrioridade.insert(1, "Luana");
        filaPrioridade.insert(5, "Lívia");
        filaPrioridade.insert(2, "Sérgio");
        filaPrioridade.insert(0, "Samuel");
        System.out.println(filaPrioridade);
        
        System.out.println(filaPrioridade.remove());
        System.out.println(filaPrioridade);
        System.out.println(filaPrioridade.remove());
        System.out.println(filaPrioridade);
        System.out.println(filaPrioridade.remove());
        System.out.println(filaPrioridade);
        System.out.println(filaPrioridade.remove());
        System.out.println(filaPrioridade);
        System.out.println(filaPrioridade.remove());
        System.out.println(filaPrioridade);
    }
}
