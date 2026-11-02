package basics;

import java.util.Scanner;

public class divisibleBy5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the number ");
        int num = scanner.nextInt();
        if (num%5==0){
            System.out.println("divisible by 5");
        }else {
            System.out.println("not divisible by 5");
        }
    }
}
