package collections;

public interface Deque<E> {
    void adicionar(E valor);
    void inserir(E valor);
    E removerPrimeiro();
    E removerUltimo();
    E primeiro();
    E ultimo();
    boolean estaVazio();
    int tamanho();
}
