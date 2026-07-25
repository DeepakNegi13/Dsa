package loops;

import java.util.Scanner;

public class tableOf17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        double num = sc.nextDouble();
        for (int i = 1;i*17<=num;i++){
            System.out.print(17*i + " ");
        }
    }
}
