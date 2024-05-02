import collections.Entrada;
import collections.SortedFilaPrioridade;
import collections.UnsortedFilaPrioridade;

public class App {
    public static void main(String[] args) throws Exception {
        UnsortedFilaPrioridade<Integer,String> ufp = new UnsortedFilaPrioridade<>(); 
        SortedFilaPrioridade<Integer,String> sfp = new SortedFilaPrioridade<>();

        ufp.inserir(2,"Cuy");
        ufp.inserir(1,"PSI");
        ufp.inserir(2, "IL1320");
        ufp.inserir(1, "Scrapper");
        ufp.inserir(0, "VerySadThing");
        ufp.inserir(3,"Josh");

        sfp.inserir(2,"Cuy");
        sfp.inserir(1,"PSI");
        sfp.inserir(2, "IL1320");
        sfp.inserir(1, "Scrapper");
        sfp.inserir(0, "VerySadThing");
        sfp.inserir(3,"Josh");
        System.out.println(ufp + "\n");
        System.out.println(sfp);
    }
}
