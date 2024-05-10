import collections.HashTable;
import collections.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String,Integer> hashMap = new HashTable<>(17);
        hashMap.put("Blush",5 );
        hashMap.put("Base",51 );
        hashMap.put("Delineador",51 );
        hashMap.put("Demaquilante",51 );

        hashMap.put("Base",0);
        System.out.println(hashMap);

    }

    public static int hashCode(String key){
        int hashCode = 0;
        int a = 5;
        for(int i = 0; i < key.length(); i++){
            hashCode = (hashCode<<a) | (hashCode>>>(32-a));
            hashCode += key.charAt(i);
        }
        return hashCode;
    }

    public int compression(int hashCode){
        return hashCode%17;
    }
}
