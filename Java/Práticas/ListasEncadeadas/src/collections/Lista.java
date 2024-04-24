package collections;

import exceptions.EmptyListException;

public interface Lista<E> {
    int tamanho();
    void adicionar(E valor);
    void inserirPrimeiro(E valor);
    void inserir(int indice, E valor) throws IndexOutOfBoundsException;
    boolean estaVazio();
    E removerUltimo() throws EmptyListException;
    E removerPrimeiro() throws EmptyListException;
    E removerPorIndice(int indice) throws EmptyListException, IndexOutOfBoundsException;
    E ver(int indice) throws EmptyListException, IndexOutOfBoundsException;
    void transformar(int indice, E valor) throws EmptyListException, IndexOutOfBoundsException;
    void limpar();
}
