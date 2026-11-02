package basics;

import java.util.Scanner;

public class divisibleBy5Or3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enetr a number ");
        double num = sc.nextDouble();
        if (num%3==0 || num%5==0){
            System.out.println("it is divisible by 5 or 3");
        }else{
            System.out.println("it is not divisible by 5 and 3");
        }
    }
}
