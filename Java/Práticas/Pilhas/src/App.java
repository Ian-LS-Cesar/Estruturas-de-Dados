import collections.PilhaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        PilhaEstatica<Integer> pilhaEstatica = new PilhaEstatica<>(5);
        pilhaEstatica.empilhar(80);
        pilhaEstatica.empilhar(20);
        pilhaEstatica.empilhar(1320);
        pilhaEstatica.empilhar(56);
        pilhaEstatica.empilhar(12);

        System.out.println(pilhaEstatica);
    }
}
