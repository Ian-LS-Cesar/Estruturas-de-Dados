import collections.CircularLinkedQueue;
import collections.CircularStaticQueue;

public class App {
    public static void main(String[] args) throws Exception {
        CircularLinkedQueue<String> fila = new CircularLinkedQueue<>();
        
        fila.enqueue("Samuel");
        fila.enqueue("Gustavo");
        fila.enqueue("Lívia");
        fila.enqueue("Ian");
        fila.enqueue("Sérgio");
        
        
        System.out.println(fila);
        fila.rotate();
        System.out.println(fila);
        fila.rotate();
        System.out.println(fila);
        fila.rotate();
        System.out.println(fila);
        fila.rotate();
        System.out.println(fila);
        fila.rotate();
        System.out.println(fila);
    }
}
