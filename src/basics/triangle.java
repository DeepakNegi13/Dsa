package basics;

import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter first number ");
        double num1 = sc.nextDouble();
        System.out.print("enter second number ");
        double num2 = sc.nextDouble();
        System.out.print("enter third number ");
        double num3 = sc.nextDouble();
        if (num1+num2>num3 && num2+num3>num1 && num1+num3>num2){
            System.out.println("these three number can form a triangle ");
        }else {
            System.out.println("these three number can't form a triangle ");


        }

    }
}
