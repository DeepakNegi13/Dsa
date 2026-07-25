package patternPrinting;

import java.util.Scanner;

public class hollowRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter row number ");
        int row = sc.nextInt();
        System.out.print("enter column number ");
        int column = sc.nextInt();
        for (int i = 1;i<=row;i++){
            for (int j = 1;j<=column;j++){
                if (i==1||i==row||j==1||j==column){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
    }

}
