import collections.DynamicStack;
import collections.StaticQueue;
import collections.StaticStack;

public class App {
    public static void main(String[] args) throws Exception {
        StaticQueue<String> fila = new StaticQueue<>();

        fila.enqueue("Anna");
        fila.enqueue("Jardiana");
        fila.enqueue("Lucas");
        // fila.dequeue();
        System.out.println(fila);
    }
}
