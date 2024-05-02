package collections;

import exceptions.EmptyDequeException;
import exceptions.FullDequeException;

public class DequeEstatico<E> implements Deque<E> {

    private int tamanho;
    private E[] deque;
    private int primeiro;
    @Override
    public void adicionar(E valor) {
        if(estaCheia()) throw new FullDequeException("O Deque está vazio!");
        deque[(primeiro + tamanho)%deque.length] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazio() {
        return tamanho() == 0;
    }

    public boolean estaCheia(){
        return tamanho == deque.length;
    }
    @Override
    public void inserir(E valor) {
        if(estaCheia()) throw new FullDequeException("O Deque está vazio!");
        primeiro = (primeiro - 1 + deque.length)%deque.length;
        deque[primeiro] = valor;
        tamanho++;
    }

    @Override
    public E primeiro() {
        if(estaVazio()) throw new EmptyDequeException("O Deque está vazio!");
        return deque[primeiro];
    }

    @Override
    public E removerPrimeiro() {
        if(estaVazio()) throw new EmptyDequeException("O Deque está vazio!");
        E valor = primeiro();
        tamanho--;
        primeiro = (primeiro + 1)%deque.length;
        return valor;
    }

    @Override
    public E removerUltimo() {
        if(estaVazio()) throw new EmptyDequeException("O Deque está vazio!");
        E valor = ultimo();
        deque[(primeiro - 1 + tamanho)%deque.length] = null;
        tamanho--;
        return valor;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public E ultimo() {
        if(estaVazio()) throw new EmptyDequeException("O Deque está vazio!");
        return deque[(primeiro - 1 + tamanho)%deque.length];
    }
    
}
