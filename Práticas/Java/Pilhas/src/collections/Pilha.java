package collections;
import exceptions.*;
public interface Pilha<E> {
    void empilhar(E valor) throws FullStackException;
    E tirar() throws EmptyStackException;
    E topo() throws EmptyStackException;
    boolean estaVazio();
    int altura();
}
