package collections;

import exceptions.EmptyListException;
import exceptions.FullListException;

public class ListaEncadeada<E> implements Lista<E> {
    private class No{
        E valor;
        No proximo;
        
        public No(E valor) {
            this.valor = valor;
        }

    }

    private int tamanho;
    private No comeco;
    private No fim;
    public ListaEncadeada(){}

    public ListaEncadeada(E valor){
        adicionar(valor);
    }

    private No verNo(int indice){
        No noAux = comeco;
        for(int i = 0; i < indice; i++){
            noAux = noAux.proximo;
        }
        return noAux;
    }
    @Override
    public void adicionar(E valor) {
        No novoNo = new No(valor);
        if (estaVazio()){
            comeco = novoNo;
        }else{
            fim.proximo = novoNo;
        }
        fim = novoNo;
        tamanho++;
        
    }

    @Override
    public boolean estaVazio() {
        return tamanho==0;
    }

    @Override
    public void inserirInicio(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            comeco = novoNo;
            fim = novoNo;
        }else{
            novoNo.proximo = comeco;
            comeco = novoNo;
        }
        tamanho++;
        
    }

    @Override
    public void inserir(int indice, E valor) throws FullListException, IndexOutOfBoundsException {
        if(estaVazio()){
            inserirInicio(valor);
        }else if(indice >= tamanho()){
            adicionar(valor);
        }else{
            No novoNo = new No(valor);
            No noAux = verNo(indice - 1);
            novoNo.proximo = noAux.proximo;
            noAux.proximo = novoNo;

        }
        tamanho++;
    }

    @Override
    public E pegar(int indice) throws EmptyListException, IndexOutOfBoundsException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("O Índice [" + indice+"] é inválido!!!");
        }
        return verNo(indice).valor;
    }

    @Override
    public E removerIndice(int indice) throws EmptyListException, IndexOutOfBoundsException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("O Índice [" + indice+"] é inválido!!!");
        }
        E valor = null;
        if (tamanho == 1){
            valor = removerPrimeiro();
        }else if(indice == tamanho - 1){
            valor = removerUltimo();
        }else{
            No noAux = verNo(indice - 1);
            No noAux2 = noAux.proximo;
            noAux.proximo = noAux2.proximo;
            valor = noAux2.valor;
            tamanho--;
        }

        return valor;
    }

    @Override
    public E removerPrimeiro() throws EmptyListException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        No noAux = comeco;
        if(tamanho == 1){
            comeco = null;
            fim = null;
        }else{
            comeco = comeco.proximo;
            noAux.proximo = null;
        }
        tamanho--;
        return noAux.valor;
    }

    @Override
    public E removerUltimo() throws EmptyListException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        E valor = fim.valor;
        if (tamanho == 1){
            removerPrimeiro();
        }else{
            No noAux = verNo(tamanho-2);
            fim = noAux;
            noAux.proximo = null;
        }
        tamanho--;
        return valor;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void transformar(int indice, E valor) throws EmptyListException, IndexOutOfBoundsException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("O Índice [" + indice+"] é inválido!!!");
        }
        verNo(indice).valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        No noAux = comeco;
        while(noAux!=null){
            sb.append(noAux.valor);
            if(noAux.proximo != null){
                sb.append(", ");
            }
            noAux = noAux.proximo;
        }
        return sb.append("]").toString();
    }  

    
}
