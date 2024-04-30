package collections;
import exceptions.EmptyListException;

public class ListaDuplamenteEncadeada<E> implements Lista<E> {
    
    private class No{
        E valor;
        No proximo;
        No anterior;

        public No(E valor) {
            this.valor = valor;
            proximo = null;
            anterior = null;
        }

        
    }

    private int tamanho;
    private No comeco;
    private No fim;

    public ListaDuplamenteEncadeada(){
        tamanho = 0;
        comeco = null;
        fim = null;
    }

    public ListaDuplamenteEncadeada(E valor){
        No novoNo = new No(valor);
        comeco = novoNo;
        fim = novoNo;
        tamanho = 1;
    }

    private No verNo(int indice){
        No noAux = comeco;
        int i = 0;
        while (i < indice){
            noAux = noAux.proximo;
            i++;
        }
        return noAux;
    }

    @Override
    public void adicionar(E valor) {
        No novoNo = new No(valor);

        if (estaVazio()){
            comeco = novoNo;
            fim = novoNo;
        }else{
            novoNo.anterior = fim;
            fim.proximo = novoNo;
            fim = novoNo;
        }
        
        tamanho++;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public void inserirPrimeiro(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            comeco = novoNo;
            fim = novoNo;
        }else{
            novoNo.proximo = comeco;
            comeco.anterior = novoNo;
            comeco = novoNo;
        }
        tamanho++;
    }

    @Override
    public void inserir(int indice, E valor) throws IndexOutOfBoundsException {
        if (indice <= 0){
            inserirPrimeiro(valor);
        }else if (indice >= tamanho){
            adicionar(valor);
        }else{
            No novoNo = new No(valor);
            No noAux = verNo(indice);
            novoNo.anterior = noAux.anterior;
            novoNo.proximo = noAux.proximo;
            noAux.proximo = novoNo;
            tamanho++;
        }
        
    }

    @Override
    public void limpar() {
        tamanho = 0;
        comeco = null;
        fim = null;
    }

    @Override
    public E ver(int indice) throws EmptyListException, IndexOutOfBoundsException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        if (indice >= tamanho || indice < 0){
            throw new IndexOutOfBoundsException("Índice " +indice+ " inválido!!!");
        }

        return verNo(indice).valor;
    }

    @Override
    public void transformar(int indice, E valor) throws EmptyListException, IndexOutOfBoundsException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        if(indice >= tamanho || indice < 0){
            throw new IndexOutOfBoundsException("Índice Inválido!!!");
        }
        if(tamanho == 1){
            inserirPrimeiro(valor);
        }
        verNo(indice).valor = valor;
    }

    @Override
    public E removerPorIndice(int indice) throws EmptyListException, IndexOutOfBoundsException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        if(indice >= tamanho || indice < 0){
            throw new IndexOutOfBoundsException("Índice " +indice+ " inválido!!!");
        }
        E valor = null;
        if(indice == 0){
            valor = removerPrimeiro();
        }else if(indice == tamanho - 1){
            valor = removerUltimo();
        }else{
            No noAux = verNo(indice);
            noAux.anterior.proximo = noAux.proximo;
            noAux.proximo.anterior = noAux.anterior;
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
            comeco = noAux.proximo;
            comeco.anterior = null;
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
        if(tamanho == 1){
            comeco = null;
            fim = null;
        }else{
            fim = fim.anterior;
            fim.proximo = null;
        }
        tamanho--;
        return valor;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        No noAux = comeco;
        while(noAux != null){
            sb.append(noAux.valor);
            if(noAux.proximo != null){
                sb.append(", ");
            }
            noAux = noAux.proximo;
        }

        return sb.append("]").toString();
    }

    public String listaInvertida() {
        StringBuilder sb = new StringBuilder("[");
        No noAux = fim;
        while(noAux != null){
            sb.append(noAux.valor);
            if(noAux.anterior != null){
                sb.append(", ");
            }
            noAux = noAux.anterior;
        }

        return sb.append("]").toString();
    }

    public void removerMeio(){
        if(estaVazio()){
        throw new EmptyListException("A Lista está vazia!!!");
        }
        int metade = tamanho / 2;

        No noAux = comeco;

        for(int i = 0; i < metade; i++){
            noAux = noAux.proximo;
        }
        noAux.anterior.proximo = noAux.proximo;
        if(noAux.proximo != null){
            noAux = noAux.proximo;
        }
        tamanho--;
    }
    
    public void removerLados(){
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        comeco = comeco.proximo;
        comeco.anterior = null;
        No noAux = comeco;
        while(noAux.proximo != null){
            noAux = noAux.proximo;
        }
        noAux = noAux.anterior;
        noAux.proximo = null;
    }
}
