package Entidades;

import Exceptions.FullListException;

public class ArrayList extends StaticList {

    public ArrayList(){
        staticList = new int[5];
    }

    private void recreateStaticList(){
        int[] newStaticList = new int[staticList.length*2];

        for(int i = 0; i <size; i++){
            newStaticList[i] = staticList[i];
        }

        staticList = newStaticList;
    }

    @Override
    public void add(int value) throws FullListException {
        if(size == staticList.length){
            recreateStaticList();
        }

        staticList[size++] = value;
        
    }

    @Override
    public void insert(int value) throws FullListException {
        if(size == staticList.length){
            recreateStaticList();
        }

        for(int i = size; i > 0; i--){
            staticList[i] = staticList[i-1];
        }

        staticList[0] = value;
        size++;
    }

    @Override
    public void insert(int index, int value) throws IndexOutOfBoundsException {
        if(size == staticList.length){
            recreateStaticList();
        }
        if(index>=size){
            add(value);
        }else{
            for(int i = size; i > index; i--){
                staticList[i] = staticList[i-1];
            }
            staticList[index] = value;
            size++;
        }
    }

    


}
