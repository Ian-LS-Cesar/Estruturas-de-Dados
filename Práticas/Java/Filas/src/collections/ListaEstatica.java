package collections;

import exceptions.EmptyListException;
import exceptions.FullListException;

public class ListaEstatica<E> implements Lista<E> {

    protected int tamanho;
    protected E[] listaEstatica;
    private final int TAMANHO_MAX = 5;

    @SuppressWarnings("unchecked")
    public ListaEstatica() {
        listaEstatica = (E[]) new Object[TAMANHO_MAX];
    }

    private void checarIndice(int indice, int referenciaIndice){
        if (indice < 0 || indice >= referenciaIndice){
            throw new IndexOutOfBoundsException("O Índice [" + indice+"] é inválido!!!");
        }
    }
    @Override
    public void adicionar(E valor) throws FullListException {
        if(estaCheia()){
            throw new FullListException("A Lista está cheia!");
        }
        listaEstatica[tamanho] = valor;
        tamanho++;
    }

    @Override
    public void inserir(E valor) throws FullListException {
        if(estaCheia()){
            throw new FullListException("A Lista está cheia!");
        }
        
        for(int i = tamanho; i > 0; i--){
            listaEstatica[i] = listaEstatica[i-1];
        }
        listaEstatica[0] = valor;
        tamanho++;
    }

    @Override
    public void inserir(int indice, E valor) throws FullListException, IndexOutOfBoundsException {
        if(estaCheia()){
            throw new FullListException("A Lista está cheia!");
        }

        checarIndice(indice, TAMANHO_MAX);

        if(indice >= tamanho){
            adicionar(valor);
        }else{

            for(int i = tamanho; i > indice; i--){
                listaEstatica[i] = listaEstatica[i-1];
            }
            listaEstatica[indice] = valor;
            tamanho++;
        }
    }

    @Override
    public E pegar(int indice) throws IndexOutOfBoundsException {
        checarIndice(indice, tamanho);
        return listaEstatica[indice];
    }

    @Override
    public E removerIndice(int indice) throws EmptyListException, IndexOutOfBoundsException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia");
        }
        checarIndice(indice, tamanho);

        E valor = listaEstatica[indice];
        for(int i = indice; i < tamanho - 1; i++){
            listaEstatica[i] = listaEstatica[i+1];
        }
        tamanho--;

        return valor;
    }

    @Override
    public E removerPrimeiro() throws EmptyListException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia");
        }
        E valor = listaEstatica[0];
        for(int i = 0; i < tamanho - 1; i++){
            listaEstatica[i] = listaEstatica[i + 1];
        }
        tamanho--;
        return valor;
    }

    @Override
    public E removerUltimo() throws EmptyListException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia");
        }
        return listaEstatica[--tamanho];
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void transformar(int indice, E valor) throws IndexOutOfBoundsException {
        checarIndice(indice, tamanho);
        listaEstatica[indice] = valor;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }
    
    public boolean estaCheia(){
        return tamanho == TAMANHO_MAX;
    }

    @Override
    public String toString() {
        String dados = "[";

        for(int i = 0; i < tamanho; i++){
            if(i==tamanho-1){
                dados = dados + listaEstatica[i];
            }else{
                dados = dados + listaEstatica[i]+", ";
            }
        }
        return dados + "]";
    }

    
}
