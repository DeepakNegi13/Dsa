package loops;

import java.util.Scanner;

public class sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        double num = sc.nextDouble();
        double n = num ;
        for (int i = 1;i<=num;i++){
            System.out.println(i);
            for (int j=(int)n;j>=1;){
                System.out.println(j);
                n--;
                break;
            }

        }
    }

}
