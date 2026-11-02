package loops;

import java.util.Scanner;

public class oddAnddivBy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        double num = sc.nextDouble();
        for (int i = 3;i<num;i=i+3){
            if (i%2!=0){
                System.out.println(i);
            }
        }
    }
}
