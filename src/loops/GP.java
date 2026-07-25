package loops;

import java.util.Scanner;

public class GP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        double num = sc.nextDouble();
        int a = 1,r=2;
        for (int i = 1;i<=num;i++){
            System.out.println(a);
            a = a*2;
        }

    }
}
