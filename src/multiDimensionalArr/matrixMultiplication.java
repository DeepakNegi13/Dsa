package multiDimensionalArr;

import java.util.Scanner;

public class matrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mat1 = {{1,2,3},{3,4,5},{6,7,8},{4,5,6}};
        int[][] mat2 = {{1,2,3,6},{3,4,5,9},{6,7,8,0}};
        int[][] mat3 = new int[mat1.length][mat2[0].length];
        for(int k = 0;k<mat1.length;k++){
            for(int j = 0;j<mat2[0].length;j++){
                int mult = 0;
                for(int i = 0;i<mat1[0].length;i++){
                    mult+= mat1[k][i]*mat2[i][j];

                }
                mat3[k][j] = mult;
            }
        }
        for(int i = 0;i<mat3.length;i++){
            for (int j = 0;j<mat3[0].length;j++){
                System.out.print(mat3[i][j]+" ");
            }
            System.out.println();
        }


    }
}
