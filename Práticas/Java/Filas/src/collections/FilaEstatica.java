package collections;

import exceptions.EmptyStackException;
import exceptions.FullStackException;

public class FilaEstatica<E> implements Fila<E> {

    private ArrayLista<E> fila;

    public FilaEstatica(){
        fila = new ArrayLista<>();
    }

    @Override
    public E desenfileirar() throws EmptyStackException {
        return fila.removerPrimeiro();
        
    }

    @Override
    public void enfileirar(E valor) throws FullStackException {
        fila.adicionar(valor);
        
    }

    @Override
    public boolean estaVazio() {
        return fila.estaVazio();
    }

    @Override
    public E primeiro() throws EmptyStackException {
        return fila.pegar(0);
    }

    @Override
    public int tamanho() {
        return fila.tamanho;
    }

    @Override
    public String toString() {
        return "Primeiro\n \\/ \n" + fila.toString();
    }

    
    
}
