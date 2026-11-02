package recursion;

import java.util.Scanner;

public class recusion_basics {
    public static void integer(int n){
        if (n==0) return ;
        integer(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        // what is recursion?
        //function calling itself.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        integer(n);
    }

}
