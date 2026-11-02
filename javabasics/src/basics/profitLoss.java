package basics;

import java.util.Scanner;

public class profitLoss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the cost price ");
        double cp = sc.nextDouble();
        System.out.print("enter selling price ");
        double sp = sc.nextDouble();

        if (sp-cp>0){
            System.out.println("profit");
        } else if (sp-cp<0) {
            System.out.println("loss");
        }else {
            System.out.println("no profit no loss");
        }

    }
}
