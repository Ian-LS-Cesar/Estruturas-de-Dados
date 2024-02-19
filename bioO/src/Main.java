import java.util.Scanner;
import java.util.Locale;
public class Main {
    public static void main(String[] args) throws Exception {
        
        int [][][] matriz = new int[][][]{
            {
                {1,9,9},
                {9,9,9},
                {9,9,9}
            },
            {
                {1,9,9},
                {9,9,9},
                {9,9,9}
            },
            {
                {9,9,9},
                {9,9,9},
                {9,9,1}
            }
        }
        
        System.out.println("Sol 1: "+ solucao1(matriz));
        System.out.println(solucao2());
        System.out.println(solucao3());
    }

    public static int funcao1 (int[] vetor){
        for(int i = 0; i < vetor.length; i++){
            if(i <= vetor.length-1){
                System.out.println(vetor[i]+", ");
            }else{
                System.out.println("]");
            }
        
        }

        for (int i = vetor.length-1; i >-1; i--){
            System.out.print(vetor[i]+" ");
        }
        

        for (int i = 0; i<vetor.length; j++ ){
            for (int j = 0; j < vetor.length; j++){
                System.out.print(i+" "+j);
            }
            System.out.println();
        }
        System.out.println("O primeiro elemento é: " + vetor[0]);
        return vetor[vetor.length-1];
    }
    
    public static int solucao1(int[][][] matriz){
        int soma = 0;

        for(int i = 0; i< matriz.length; i++){
            for (int j = 0; j < matriz[0].length; j++){
                for(int k = 0; k = 0; k < matriz[0][0].length; k++){
                    if (i == j && j == k){
                        soma+=matriz[i][j][j];
                    }
                }
            }
        }
        return 0;
    }
    public static int solucao2(){
        return 0;
    }

    public static int solucao3(){
        return 0;
    }

}
    

