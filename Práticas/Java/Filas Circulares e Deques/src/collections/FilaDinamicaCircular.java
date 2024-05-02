package collections;

import exceptions.EmptyDequeException;
import exceptions.EmptyQueueException;

public class FilaDinamicaCircular<E> implements Fila<E> {

    class No{
        E valor;
        No proximo;
        public No(E valor){
            this.valor = valor;
        }
    }

    private No primeiro;
    private No ultimo;
    private int tamanho;
    
    @Override
    public E desenfileirar() {
        if (estaVazio()) throw new EmptyQueueException("A Fila está vazia!");
        E valor = primeiro();
        if(tamanho == 1){
            primeiro = null;
            ultimo = null;
        }else{
            primeiro = primeiro.proximo;
            ultimo.proximo = primeiro;
        }
        tamanho--;
        return valor;
    }

    @Override
    public void enfileirar(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            primeiro = novoNo;
        }else{
            ultimo.proximo = novoNo;
        }
        ultimo = novoNo;
        ultimo.proximo = primeiro;
        tamanho++;
        
    }

    @Override
    public boolean estaVazio() {
        return tamanho() == 0;
    }

    public void rotate(){
        primeiro = primeiro.proximo;
        ultimo = ultimo.proximo;
    }
    @Override
    public E primeiro() {
        if(estaVazio()) throw new EmptyQueueException("A Fila está vazia!");
        return primeiro.valor;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        
        No noAux = primeiro;
        for(int i = 0; i < tamanho; i++){
            sb.append(noAux.valor);
            if(i!=tamanho-1){
                sb.append(", ");
            }
            noAux = noAux.proximo;
        }
        sb.append("]");
        return sb.toString();
    }
    
    
    
}