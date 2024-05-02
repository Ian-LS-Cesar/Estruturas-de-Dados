package collections;

public interface Fila<E> {
    void enfileirar(E valor);
    E desenfileirar();
    E primeiro();
    boolean estaVazio();
    int tamanho();
}
