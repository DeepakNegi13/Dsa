package basics;

import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the radius ");
        double r = sc.nextDouble();
        double sq = r*r;
        System.out.println("square of " + r + " is "+sq);
    }
}
