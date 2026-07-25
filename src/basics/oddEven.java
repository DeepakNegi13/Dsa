package basics;

import java.util.Scanner;

public class oddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number ");
        double num = sc.nextDouble();
        if (num%2==0){
            System.out.println("even number");
        }
        else {
            System.out.println("odd number");
        }
    }
}
