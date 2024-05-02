package collections;

import exceptions.EmptyPriorityQueueException;

public class SortedFilaPrioridade<K,V> extends FilaPrioridadeAbstrata<K,V> {

    @Override
    public void inserir(K chave, V valor) {
        No novoNo = new No(chave, valor);

        if(estaVazio()){
            primeiro = novoNo;
            ultimo = novoNo;
        }else{
            if(comparar(novoNo.entrada,primeiro.entrada)<0){
                novoNo.proximo = primeiro;
                primeiro.anterior = novoNo;
                primeiro = novoNo;
            }else if(comparar(novoNo.entrada, ultimo.entrada) >= 0){
                ultimo.proximo = novoNo;
                novoNo.anterior = ultimo;
                ultimo = novoNo;
            }else{
                No noAux = primeiro;
                while(comparar(novoNo.entrada, noAux.entrada)>= 0){
                    noAux = noAux.proximo;
                }
                novoNo.proximo = noAux;
                novoNo.anterior = noAux.anterior;
                noAux.anterior.proximo = novoNo;
                noAux.anterior = novoNo;
            }
        }
        tamanho--;
        
    }

    @Override
    public Entrada<K, V> prioridadeMax() {
        if(estaVazio()) throw new EmptyPriorityQueueException("A Fila de Prioridade está vazia!");
        return primeiro.entrada;
    }

    @Override
    public Entrada<K, V> remover() {
        if(estaVazio()) throw new EmptyPriorityQueueException("A Fila de Prioridade está vazia!");
        Entrada<K,V> entrada = primeiro.entrada;
        
        if(tamanho == 1){
            primeiro = null;
            ultimo = null;
        }else{
            primeiro = primeiro.proximo;
            primeiro.anterior = null;
        }
        tamanho--;
        return entrada;
    }
    
}
