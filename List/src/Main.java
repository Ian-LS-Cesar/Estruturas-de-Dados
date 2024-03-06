import Entidades.List;
import Entidades.StaticList;

public class Main {
    public static void main(String[] args) throws Exception {
        List idades = new StaticList();

        idades.add(21);
        idades.add(19);
        idades.insert(48);
        idades.add(999);

        System.out.println(idades);
    }
}

