package basics;

import java.util.Scanner;

public class specialuestion {
        static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter a positive integers");
            double num = sc.nextDouble();
            if (num%5==0 && num%3==0){
                System.out.println("ananya");


            } else if (num%5==0) {
                System.out.println("riya");
            } else if (num%3==0) {
                System.out.println("bhanu");
            } else {
                System.out.println("insha");
            }
        }
}

