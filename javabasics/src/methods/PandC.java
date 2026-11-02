package methods;

import java.util.Scanner;

public class PandC {
    public static int fact(int a){
        int fact=1;
        for (int i = 1;i<=a;i++){
            fact = fact*i;

        }
        return (a==0)?1:fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n ");
        int n= sc.nextInt();
        System.out.println("enter the value of r ");
        int r= sc.nextInt();


        //for nCr
        int nCr=fact(n)/(fact(r)*fact(n-r));


        //for nPr
        int nPr=fact(n)/fact(n-r);
        System.out.println("value of nCr = "+nCr);
        System.out.println("value of npr = "+nPr);


    }
}
