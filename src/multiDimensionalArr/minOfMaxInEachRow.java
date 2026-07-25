package multiDimensionalArr;

import java.util.Scanner;

public class minOfMaxInEachRow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][4];
        for (int i = 0;i<3;i++){
            for (int j = 0 ;j<4;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("\n");
        }
        int mintotal = Integer.MAX_VALUE;
        for (int i = 0 ;i<3;i++){
            int maxRow = Integer.MIN_VALUE;
            for (int j = 0;j<4 ; j++){
                maxRow = Math.max(maxRow,arr[i][j]);
            }
            mintotal = Math.min(maxRow,mintotal);
        }
        System.out.println(mintotal);
    }
}
