package loops;

import java.util.Scanner;

public class evenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        double num = sc.nextDouble();
        for (int i = 2;i<=num;i=i+2){
            System.out.print(i+" ");
        }


    }
}
