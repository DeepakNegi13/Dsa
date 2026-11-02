package basics;

import java.util.Scanner;

public class magGreaterThen69 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        double num = sc.nextDouble();
        if(num<0){
            if (-num>69){
                System.out.println("magnitude of number is greater than 69 ");
            }else {
                System.out.println("magnitude of number is less or equal to than 69");
            }
        }else {
            if (num>69){
                System.out.println("magnitude of number is greater than 69 ");
            }else {
                System.out.println("magnitude of number is less or equal to than 69");
            }

        }

    }
}