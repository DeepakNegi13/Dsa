package basics;

import java.util.Scanner;

public class absoluteValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        double num = sc.nextDouble();
//        if (num<0){
//            num = -num;
//            System.out.print(num);
//        }else {
//            System.out.print(num);

        if (num<0){
            num = -num;
        }
        System.out.println(num);

    }
}
