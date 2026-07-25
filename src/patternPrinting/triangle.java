package patternPrinting;

import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter row number ");
        int row = sc.nextInt();
        for (int i = 1 ;i<=row;i++){
            if (i%2==0){
                for (int j = 1;j<=i;j++){
                    System.out.print((char)(j+64)+ " ");
                }
            }else {
                for (int j = 1;j<=i;j++){
                    System.out.print(j+ " ");
                }

            }
            System.out.print("\n");
        }

    }
}
