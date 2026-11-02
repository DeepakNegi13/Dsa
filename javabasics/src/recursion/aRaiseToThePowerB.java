package recursion;

import java.util.Scanner;

public class aRaiseToThePowerB {
    public static int pow(int a , int b ) {
        if(b==0) return 1;
        if (b%2==0){
            return pow(a,b/2)*pow(a,b/2);
        }else {
            return a*pow(a,b/2)*pow(a,b/2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(pow(a,b));
    }
}
