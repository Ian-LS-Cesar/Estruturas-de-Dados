import java.util.Scanner;
import collections.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        LinkedList<Integer> lista = new LinkedList<>();
        
        int contador = leitor.nextInt();

        
        for (int i = 0; i < contador; i++){
            int numero = leitor.nextInt();
            
            lista.add(numero);
        }

        System.out.println(lista);
        System.out.print(lista.midNode(contador));
        leitor.close();

    }
}
