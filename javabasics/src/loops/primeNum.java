package loops;

import java.util.Scanner;

public class primeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        double num = sc.nextDouble();
        boolean prime = true;
        for (int i =2;i<Math.sqrt(num);i++){
            if(num%i==0){
                // i num ka ak factor hai isliye break kar do
                prime = false;
                break;
            }
        }
        if (num==1) System.out.println("neither prime nor composite");
        else if (prime == true){
            System.out.println("it is a prime number");
        }else {
            System.out.println("it is a composite number");
        }
    }
}
