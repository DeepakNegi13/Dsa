package recursion;

import java.util.Scanner;

public class reverseOfANumber {
    public static int Rev(int n ,int r){
        if(n==0) return r;

        return Rev(n/10,r*10+n%10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rev = 0;
        System.out.print(Rev(n,rev));
    }
}
