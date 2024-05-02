package collections;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class FilaEstaticaCircular<E> implements Fila<E> {
    
    private int tamanho;
    private E[] fila;
    private int primeiro;

    @SuppressWarnings("unchecked")
    public FilaEstaticaCircular(int tamanhoMax){
        fila = (E[]) new Object[tamanhoMax];
    }

    @Override
    public E desenfileirar() {
        if(estaVazio()) throw new EmptyQueueException("A Fila está vazia!");
        E valor = primeiro();
        fila[primeiro] = null;
        primeiro = (primeiro+1)%fila.length;
        tamanho--;
        return valor;

    }

    @Override
    public void enfileirar(E valor) {
        if(estaCheia()) throw new FullQueueException("A Fila está cheia!");
        fila[(primeiro + tamanho)%fila.length] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazio() {
        return tamanho() == 0;
    }

    public boolean estaCheia(){
        return tamanho == fila.length;
    }

    @Override
    public E primeiro() {
        if(estaVazio()) throw new EmptyQueueException("A Fila está vazia!");
        return fila[primeiro];
    }

    @Override
    public int tamanho() {
        return tamanho;
    }
    
    
}
