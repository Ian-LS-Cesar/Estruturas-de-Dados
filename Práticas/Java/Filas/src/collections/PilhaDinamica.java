package collections;

import exceptions.EmptyStackException;
public class PilhaDinamica<E> implements Pilha<E> {

    class No{
        E valor;
        No proximo;
        public No(E valor){
            this.valor = valor;
        }
    }

    private No topo;
    private int altura;
    @Override
    public void adicionar(E valor) {
        No novoNo = new No(valor);
        if(!estaVazio()){
            novoNo.proximo = topo;
        }
        topo = novoNo;
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

    @Override
    public E tirar() {
        if(estaVazio()){
            throw new EmptyStackException("A Pilha está vazia!");
        }
        E valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    @Override
    public E topo() {
        if(estaVazio()){
            throw new EmptyStackException("A Pilha está vazia!");
        }
        return topo.valor;
    }
    
}
