package patternPrinting;

import java.util.Scanner;

public class flippedtriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter row number ");
        int row = sc.nextInt();
        for (int i = 1;i<=row;i++){
            for (int j = 1;j<=row-i+1;j++){
                System.out.print((char)+(j+96)+" ");
            }
            System.out.print("\n");
        }
    }
}
