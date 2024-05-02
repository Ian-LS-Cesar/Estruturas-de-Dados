package collections;

import exceptions.EmptyPriorityQueueException;

public class UnsortedFilaPrioridade<K,V> extends FilaPrioridadeAbstrata<K,V> {

    @Override
    public void inserir(K chave, V valor) {
        No novoNo = new No(chave, valor);
        if(estaVazio()){
            primeiro = novoNo;
        }else{
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
        }
        ultimo = novoNo;
        tamanho++;
        
    }

    private No encontrarMin(){
        No noMin = ultimo;
        No noAux = ultimo.anterior;

        while(noAux != null){
            int comp = comparar(noAux.entrada, noMin.entrada);
            if(comp == -1 || comp == 0){
                noMin = noAux;
            }

            noAux = noAux.anterior;
        }

        return noMin;
    }

    @Override
    public Entrada<K, V> prioridadeMax() {
        if(estaVazio()) throw new EmptyPriorityQueueException("A Fila de Prioridade está vazia!");
        return encontrarMin().entrada;
    }

    @Override
    public Entrada<K, V> remover() {
        if(estaVazio()) throw new EmptyPriorityQueueException("A Fila de Prioridade está vazia!");

        No noMin = encontrarMin();

        if(tamanho == 1){
            primeiro = null;
            ultimo = null;
        }else{
            if(noMin == primeiro){
                System.out.println("Removendo o primeiro...");
                primeiro = primeiro.proximo;
                primeiro.anterior = null;
            }else if(noMin == ultimo){
                System.out.println("Removendo o último...");
                ultimo = ultimo.anterior;
                ultimo.proximo = null;
            }else{
                System.out.println("Removendo alguém entre o primeiro e o último...");
                noMin.anterior.proximo = noMin.proximo;
                noMin.proximo.anterior = noMin.anterior;
            }
        }
        tamanho--;
        return noMin.entrada;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
    

}
