package collections;

import exceptions.EmptyStackException;

public class PilhaDinamica<E> implements Pilha<E> {

    class No{
        E valor;
        No proximo;
        
        public No(E valor) {
            this.valor = valor;
        }
        
    }

    private No topo;
    private int altura;

    @Override
    public int altura() {
        return altura();
    }

    @Override
    public void empilhar(E valor) {
        No novoNo = new No(valor);
        if(!estaVazio()){
            novoNo.proximo = topo;
        }
        topo = novoNo;
        altura++;
        
    }

    @Override
    public boolean estaVazio() {
        return topo == null;
    }

    @Override
    public E tirar() throws EmptyStackException {
        if(estaVazio()){
            throw new EmptyStackException("A Pilha está vazia");
        }
        E valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    @Override
    public E topo() throws EmptyStackException {
        if(estaVazio()){
            throw new EmptyStackException("A Pilha está vazia");
        }
        return topo.valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        No noAux = topo;
        while (noAux != null){
            sb.append(noAux.valor);
            if(noAux == topo){
                sb.append(" <- Topo");
            }
            sb.append("\n");
            noAux = noAux.proximo;
        }
        return sb.toString();
    }

    

}
