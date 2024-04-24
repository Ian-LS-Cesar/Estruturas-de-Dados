import collections.*;

public class App {
    public static void main(String[] args) throws Exception {

        ListaDuplamenteEncadeada<String> l2 = new ListaDuplamenteEncadeada<>();
        l2.adicionar("Pompompurin");
        l2.adicionar("Cuy");
        l2.adicionar("IL");
        l2.adicionar("PSI");
        l2.adicionar("Scrapper");
        System.out.println(l2);

    }
}
