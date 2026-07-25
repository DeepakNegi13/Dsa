package patternPrinting;

import java.util.Scanner;

public class binaryTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter  number ");
        int n = sc.nextInt();
        int bin=1;
        for (int i = 1;i<=n;i++) {
            if (i%2==0){
                bin=0;
            }else {
                bin=1;
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(bin+" ");
                if (bin==0){
                    bin=1;
                }else {
                    bin=0;
                }
            }
            System.out.print("\n");
        }

    }
}
