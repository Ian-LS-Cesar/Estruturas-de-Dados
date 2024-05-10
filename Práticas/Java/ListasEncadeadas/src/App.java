import collections.*;

public class App {
    public static void main(String[] args) throws Exception {
     ListaEncadeada<Integer> lista = new ListaEncadeada<>();
     
        lista.adicionar(13);
        lista.adicionar(125);
        lista.adicionar(1213);
        lista.adicionar(22);
        lista.adicionar(12);
        lista.adicionar(34);

        System.out.println(lista);
        lista.reversao();
        System.out.println(lista);


        
    }
}
