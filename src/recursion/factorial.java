package recursion;

import java.util.Scanner;

public class factorial {
    public static int fac(int n ){
        if (n==1||n==0) return 1;
        return n*fac(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fac(n));


    }
}
