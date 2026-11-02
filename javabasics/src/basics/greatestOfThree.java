package basics;

import java.util.Scanner;

public class greatestOfThree {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the 1st number");
        double num1 = sc.nextDouble();
        System.out.print("enter the 2nd number");
        double num2 = sc.nextDouble();
        System.out.print("enter the 3rd number");
        double num3 = sc.nextDouble();
        if(num1>num2 && num1>num3){
            System.out.println(num1);
        } else if (num2>num3) {
            System.out.println(num2);

        }else if (num3>num2){
            System.out.println(num3);
        }else {
            System.out.println("all are equal");
        }
    }
}
