package patternPrinting;

import java.util.Scanner;

public class plusPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter row number ");
        int row = sc.nextInt();
        System.out.print("enter column number ");
        int column = sc.nextInt();
        for (int i = 1 ;i<=2*row+1;i++){
            for (int j = 1 ;j<=2*column+1;j++){
                if (i==row+1||j==column+1){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }

            }
            System.out.print("\n");
        }
    }

}
