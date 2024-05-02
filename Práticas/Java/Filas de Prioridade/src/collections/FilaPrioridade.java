package collections;

public interface FilaPrioridade<K,V> {
    void inserir(K chave, V valor);
    Entrada<K,V> prioridadeMax();
    Entrada<K,V> remover();
    int tamanho();
    boolean estaVazio();
}
