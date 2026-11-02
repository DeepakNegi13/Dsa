package string;

import java.util.Scanner;

public class intCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        String s = "";
        s+=n;
        System.out.println(s.length()-1);
    }
}
