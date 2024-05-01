package collections;

public interface Pilha<E> {
    void adicionar(E valor);
    E tirar();
    E topo();
    boolean estaVazio();
    int altura();
}
