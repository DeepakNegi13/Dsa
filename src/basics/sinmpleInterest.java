package basics;

import java.util.Scanner;

public class sinmpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter amount deposit ");
        double pri = sc.nextDouble();

        System.out.print("enter interest rate ");
        double rate = sc.nextDouble();

        System.out.print("enter time in years ");
        double time  = sc.nextDouble();

        double interest = pri + pri*rate*time/100;
        System.out.println("interest " + interest);

        double amount = pri + pri*rate*time/100;
        System.out.println("Amount " + amount);


    }
}
