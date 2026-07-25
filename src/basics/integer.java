package basics;

import java.util.Scanner;

public class integer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number ");
        double num = sc.nextDouble();
        int x = (int)num;
        if (num-x==0){
            System.out.println("number is an integer");
        }else {
            System.out.println("number is not  an integer");
        }
    }
}
