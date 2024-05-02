package collections;

import exceptions.EmptyStackException;
import exceptions.FullStackException;
public class PilhaEstatica<E> implements Pilha<E> {
    private int altura;
    private E[] pilha;

    @SuppressWarnings("unchecked")
    public PilhaEstatica(int tamanhoMax){
        pilha = (E[])new Object[tamanhoMax];
    }

    @Override
    public void adicionar(E valor) {
        if(estaCheio()){
            throw new FullStackException("A Pilha está cheia!!!");
        }
        
        pilha[altura] = valor;
        altura++;
    }

    @Override
    public int altura() {
        return altura;
    }

    @Override
    public boolean estaVazio() {
        return altura == 0;
    }

    public boolean estaCheio(){
        return altura == pilha.length;
    }
    @Override
    public E tirar() {
        if(estaVazio()){
            throw new EmptyStackException("A Pilha está vazia!!!");
        }
        return pilha[--altura];
    }

    @Override
    public E topo() {
        if(estaVazio()){
            throw new EmptyStackException("A Pilha está vazia!!!");
        }
        return pilha[altura-1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for(int i = altura - 1; i >= 0; i--){
            sb.append(pilha[i]);
            if(i == altura - 1){
                sb.append(" -> Topo");
            }

                sb.append("\n");
        }
        return sb.toString();
    }
    
   
}
