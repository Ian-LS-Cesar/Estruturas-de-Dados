package collections;

import exceptions.EmptyDequeException;

public class DequeDuplamenteEncadeado<E> implements Deque<E> {
    class No{
        No proximo;
        No anterior;
        E valor;
        public No(E valor){
            this.valor = valor;
        }
    }

    No primeiro;
    No ultimo;
    int tamanho;
    @Override
    public void adicionar(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            primeiro = novoNo;
        }else{
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
        }
        ultimo = novoNo;
        tamanho++;
        
    }
    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }
    @Override
    public void inserir(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            ultimo = novoNo;
        }else{
            novoNo.proximo = primeiro;
            primeiro.anterior = novoNo;
        }
        primeiro = novoNo;
        tamanho++;
        
    }
    @Override
    public E primeiro() {
        if(estaVazio()) throw new EmptyDequeException("O Deque está vazio");
        return primeiro.valor;
    }
    @Override
    public E removerPrimeiro() {
        if(estaVazio()) throw new EmptyDequeException("O Deque está vazio");
        E valor = primeiro();

        if(tamanho == 1){
            primeiro = null;
            ultimo = null;
        }else{
            primeiro.proximo.anterior = null;
            primeiro = primeiro.proximo;
        }
        tamanho--;
        return valor;
    }
    @Override
    public E removerUltimo() {
        if(estaVazio()) throw new EmptyDequeException("O Deque está vazio");
        E valor = ultimo();

        if(tamanho == 1){
            primeiro = null;
            ultimo = null;
        }else{
            ultimo = ultimo.anterior;
            ultimo.proximo = null;
        }
        tamanho--;
        return valor;
    }
    @Override
    public int tamanho() {
        return tamanho;
    }
    @Override
    public E ultimo() {
        if(estaVazio()) throw new EmptyDequeException("O Deque está vazio");
        return ultimo.valor;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        No noAux = primeiro;

        while(noAux!=null){
            sb.append(noAux.valor);
            if(noAux.proximo!=null){
                sb.append(", ");
            }
            
            noAux = noAux.proximo;
        }
        sb.append("]");
        return sb.toString();
    }

    
}
