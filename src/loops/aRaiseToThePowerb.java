package loops;

import java.util.Scanner;

public class aRaiseToThePowerb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter base number ");
        int base = sc.nextInt();
        System.out.print("enter power number ");
        int power = sc.nextInt();
        int ans=1;
        for (int i = 1;i<=power;i++){
            ans=ans*base;
        }
        System.out.println((power==0)?1:ans);


    }
}
