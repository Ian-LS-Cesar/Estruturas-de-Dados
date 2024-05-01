package collections;

import exceptions.EmptyListException;
import exceptions.FullListException;

public interface Lista<E> {
    void adicionar(E valor) throws FullListException;
    void inserir(E valor) throws FullListException;
    void inserir(int indice, E valor) throws FullListException, IndexOutOfBoundsException;
    E removerUltimo() throws EmptyListException;
    E removerPrimeiro() throws EmptyListException;
    E removerIndice(int indice) throws EmptyListException, IndexOutOfBoundsException;
    boolean estaVazio();
    E pegar(int indice) throws EmptyListException, IndexOutOfBoundsException;
    void transformar(int indice, E valor) throws EmptyListException, IndexOutOfBoundsException;
    int tamanho();
}
