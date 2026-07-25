package patternPrinting;

import java.util.Scanner;

public class alphabetsqr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter row number ");
        int row = sc.nextInt();
        System.out.print("enter column number ");
        int column = sc.nextInt();
        for (int i=1;i<=row;i++) {
            for (int j = 97; j <= column + 96; j++) {
                System.out.print((char) j+" ");
            }
            System.out.print("\n");
        }
    }
}
