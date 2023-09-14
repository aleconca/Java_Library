package Visibilita;

public class Array {

    public static void main(String[] args){
        int[] p= {1,2,3};

        int[][] m={ {1,2},{3,4}};

        int result=0;
        int i=0;

        for(int n : p){
            result = result+p[i];
            i++;
        }

        int x =0;
        int y =0;
        for(int[] w : m){
            System.out.println(m[x][y]);
            x++;

        }

        System.out.println(result);


    }
}
