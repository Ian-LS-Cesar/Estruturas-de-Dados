import collections.SortedPriorityQueue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);

        int N = leitor.nextInt();

        for (int i = 0; i < N; i++){
            int M = leitor.nextInt();
            SortedPriorityQueue<Integer,Integer> fila = new SortedPriorityQueue<>();
            for (int j = 1; j <= M; j++){
                int notaAluno = leitor.nextInt();
                fila.insert(notaAluno,notaAluno);
            }
            System.out.println(fila);
        }
    }
}
