package collections;

import exceptions.*;

public class PilhaEstatica<E> implements Pilha<E> {

    private int altura;
    private E[] pilha;
    
    @SuppressWarnings("unchecked")
    public PilhaEstatica(int alturaMax){
        pilha = (E[])new Object[alturaMax];
    }

    @Override
    public int altura() {
        return altura;
    }

    @Override
    public void empilhar(E valor) throws FullStackException {
       if(estaCheia()){
        throw new FullStackException("A Pilha está cheia!!!");
       }
       
       pilha[altura] = valor;
       altura++;
    }

    @Override
    public boolean estaVazio() {
        return altura == 0;
    }

    public boolean estaCheia() throws FullStackException {
        return altura == pilha.length;
    }

    @Override
    public E tirar() throws EmptyStackException{
        if(estaVazio()){
            throw new EmptyStackException("A Pilha está vazia!!!");
        }
        return pilha[--altura];
    }

    @Override
    public E topo() throws EmptyStackException {
        if(estaVazio()){
            throw new EmptyStackException("A Pilha está vazia!!!");
        }
        return pilha[altura - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = altura-1; i>=0; i--){
            sb.append(pilha[i]);
            if(i == altura-1){
                sb.append(" -> Topo");
            }
                sb.append("\n");
        }
        return sb.toString();
    }
    
    
}
