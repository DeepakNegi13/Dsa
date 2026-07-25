package basics;

import java.util.Scanner;

public class _4DSigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number ");
        double num = sc.nextDouble();
        if (num>999 && num<10000){
            System.out.print("it is a 4 digit number");
        }else {
            System.out.println("it is not a 4 digit number");
        }
        
    }
}
