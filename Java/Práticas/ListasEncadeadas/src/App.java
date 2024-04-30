import collections.*;

public class App {
    public static void main(String[] args) throws Exception {

        ListaDuplamenteEncadeada<String> listaDupla = new ListaDuplamenteEncadeada<>();
        listaDupla.adicionar("Pompompurin");
        listaDupla.adicionar("Cuy");
        listaDupla.adicionar("IL");
        listaDupla.adicionar("PSI");
        listaDupla.adicionar("Scrapper");
        System.out.println(listaDupla);
        System.out.println(listaDupla.listaInvertida());
        listaDupla.removerLados();
        System.out.println(listaDupla);
    }
}
