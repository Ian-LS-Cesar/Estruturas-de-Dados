package collections;

import exceptions.EmptyStackException;
import exceptions.FullStackException;

public interface Fila<E> {
    void enfileirar(E valor) throws FullStackException;
    E desenfileirar() throws EmptyStackException;
    E primeiro() throws EmptyStackException;
    int tamanho();
    boolean estaVazio();
}
