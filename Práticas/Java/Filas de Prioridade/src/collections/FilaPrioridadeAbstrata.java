package collections;

import java.util.Comparator;
public abstract class FilaPrioridadeAbstrata<K,V> implements FilaPrioridade<K,V> {
    
    class EntradaFilaPrioridade implements Entrada<K,V>{

        K chave;
        V valor;
        
        public EntradaFilaPrioridade(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        @Override
        public K pegarChave() {
            return chave;
        }

        @Override
        public V pegarValor() {
            return valor;
        }

        @Override
        public String toString() {
            return "(" + chave + " - " + valor + ")";
        }
    }

    class No{
        No proximo;
        No anterior;
        Entrada<K,V> entrada;

        public No(K chave, V valor){
            entrada = new EntradaFilaPrioridade(chave, valor);
        }

        public No(Entrada<K,V> entrada){
            this.entrada = entrada;
        }
    }

    protected int tamanho;
    protected No primeiro;
    protected No ultimo;
    private Comparator<K> comparador;
    
    public FilaPrioridadeAbstrata(Comparator<K> comparador) {
        this.comparador = comparador;
    }

    public FilaPrioridadeAbstrata(){
        comparador = new DefaultComparator<>();
    }
    
    public int comparar(Entrada<K,V> e1, Entrada<K,V> e2){
        return comparador.compare(e1.pegarChave(),e2.pegarChave());
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        No noAux = primeiro;

        while(noAux != null){
            sb.append(noAux.entrada);
            if(noAux.proximo != null){
                sb.append(", ");
            }
            noAux = noAux.proximo;
        }

        sb.append("]");
        return sb.toString();
    }

}
        
        


