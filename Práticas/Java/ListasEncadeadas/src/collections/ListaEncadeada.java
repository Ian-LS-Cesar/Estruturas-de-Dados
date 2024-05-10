package collections;
import exceptions.EmptyListException;
public class ListaEncadeada<E> implements Lista<E> {

    private class No{
        E valor;
        No proximo;
        
        public No(E valor) {
            this.valor = valor;
            proximo = null;
        }

        
    }

    private int tamanho;
    private No comeco;
    private No fim;

    public ListaEncadeada(){
        tamanho = 0;
        comeco = null;
        fim = null;
    }

    public ListaEncadeada(E valor){
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
            No noAux = verNo(indice - 1);
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
            throw new IndexOutOfBoundsException("Índice Inválido!!!");
        }

        return verNo(indice).valor;
    }

    @Override
    public E removerPorIndice(int indice) throws EmptyListException, IndexOutOfBoundsException {
        if(estaVazio()){
            throw new EmptyListException("A Lista está vazia!!!");
        }
        if(indice >= tamanho || indice < 0){
            throw new IndexOutOfBoundsException("Índice Inválido!!!");
        }
        E valor = null;
        if(indice == 0){
            valor = removerPrimeiro();
        }else if(indice == tamanho - 1){
            valor = removerUltimo();
        }else{
            No noAux1 = verNo(indice - 1);
            No noAux2 = noAux1.proximo;
            valor = noAux2.valor;
            noAux1.proximo = noAux2.proximo;
            noAux2 = null;
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
            No noAux = verNo(tamanho - 2);
            fim = noAux;
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

    
    
}
