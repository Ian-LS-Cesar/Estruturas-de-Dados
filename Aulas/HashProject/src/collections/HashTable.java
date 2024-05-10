package collections;

public class HashTable<K,V> implements Map<K,V> {


    private Node<Entry<K,V>>[] hashTable;
    private int size;

    


    @SuppressWarnings("unchecked")
    public HashTable(int mapSize) {
        hashTable = new Node[mapSize];
    }

    private int hashCode(String key){
        int hashCode = 0;
        int a = 5;
        for(int i = 0; i < key.length(); i++){
            hashCode = (hashCode<<a) | (hashCode>>>(32-a));
            hashCode += key.charAt(i);
        }
        return hashCode;
    }

    private int compression(int hashCode){
        int comp = hashCode%hashTable.length;
        // comp = comp<0?comp*-1:comp;
        if(comp<0){
            comp*=-1;
        }
        return comp;
    }

    private int hashFunction(K key){
        if(key instanceof String){
            return compression(hashCode(((String)key)));
        }


        throw new RuntimeException("HashCode does not support that data type (YET!)");

    }

    @Override
    public Entry<K, V> delete(K key) {
        int index = hashFunction(key);
        Node<Entry<K,V>> auxNode = getNodeByKey(key);

        
        
    }

    public Node<Entry<K,V>> getNodeByKey(K key){
        int index = hashFunction(key);
        Node<Entry<K,V>> auxNode = getNodeByKey(key);
        while (auxNode != null){
            if(auxNode == key){

            }
        }
    }
    @Override
    public Entry<K, V> get(K key) {
        return getNodeByKey(key).entry;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {
        int index = hashFunction(key);
        Entry<K,V> entry = new HashEntry<>(key, value);
        Node<Entry<K,V>> newNode = new Node<>(entry);
        if(hashTable[index] == null){
            hashTable[index] = newNode;
        }else{
            Node<Entry<K,V>> auxNode = hashTable[index];
            boolean found = false;
            while(auxNode!=null){
                if(auxNode.entry.getKey().equals(key)){
                    auxNode.entry.setValue(value);
                    found = true;
                }
                auxNode = auxNode.next;
            }

            if(!found){
                hashTable[index].previous = newNode;
                newNode.next = hashTable[index];
                hashTable[index] = newNode;
            }
        }

        size++;
        
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < hashTable.length; i++){
            sb.append(i);
            sb.append(":");

            Node<Entry<K,V>> auxNode = hashTable[i];
            while(auxNode!=null){
                sb.append("\n    ");
                sb.append(auxNode.entry);
                auxNode = auxNode.next;
            }

            sb.append("\n");

        }

        return sb.toString();

    }


    

    

}
