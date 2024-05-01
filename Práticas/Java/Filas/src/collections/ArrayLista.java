package collections;


public class ArrayLista<E> extends ListaEstatica<E> {
    
    @SuppressWarnings("unckecked")
    public ArrayLista(){
        listaEstatica = (E[]) new Object[5];
    }
    @SuppressWarnings("unckecked")
    private void recriarListaEstatica(){
        E[] novaListaEstatica = (E[]) new Object[listaEstatica.length*2];
        for(int i = 0; i < tamanho; i++){
            novaListaEstatica[i] = listaEstatica[i];
        }
        listaEstatica = novaListaEstatica;
    }
    @Override
    public void adicionar(E valor)  {
        if(tamanho == listaEstatica.length){
            recriarListaEstatica();
        }

        listaEstatica[tamanho] = valor;
        tamanho++;
    }

    @Override
    public void inserir(E valor)  {
        super.inserir(valor);
    }

    @Override
    public void inserir(int indice, E valor) {
        super.inserir(indice, valor);
    }
    
}
