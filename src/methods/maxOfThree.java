package methods;

import java.util.Scanner;

public class maxOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter four numbers");
        double num1=sc.nextDouble();
        double num2=sc.nextDouble();
        double num3=sc.nextDouble();
        double num4 =sc.nextDouble();
        System.out.println(Math.max(Math.max(num1,num2),Math.max(num3,num4)));
    }
}
