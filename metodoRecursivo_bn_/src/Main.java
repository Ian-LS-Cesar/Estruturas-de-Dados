public class Main{
    public static void main(String[] args) {
            System.out.println(Recursao.seno(90,20));

    }
}
class Recursao {
    
    private static int somaBinaria(int[] v, int l, int u){
        if (l > u){
            return 0;
        } else if (l == u){
            return v[u];
        }
        
        int m = (l + u)/2;

        return somaBinaria(v, l, m) + somaBinaria(v, m+1, u);
    }
    
    public static int somaBinaria(int[] v){
        return somaBinaria(v, 0, v.length-1);
    }
    
    
    
    public static int exercicio1(int b, int n){
        if (n == 0) {
            return 1;
        }

        return b * exercicio1(b, n-1);
    }


    private static double seno(double x, int n, int j, double t){
        
        if (n == 1){
            return x;
        }

        t = t * (x*x)/(j*(j-1))*-1;
        return t + seno(x, n-1, j+2, t);

    }

    public static double seno(double angulo, int n){
        double radianos = deg2rad(angulo);
        return seno(radianos, n, 3 , radianos);    
    }

    public static double deg2rad(double angulo){
        return angulo*Math.PI/180;
    }
}