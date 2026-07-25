package array;

import java.util.Scanner;

public class twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("enter sum of the two elements ");
        int sum = sc.nextInt();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++){
            for (int j = i+1;j<arr.length;j++){
                if (i!=j && arr[i]+arr[j]==sum){

                    System.out.println(arr[j]+ " "+ arr[i]);
                    flag =false;

                }
            }
            if (flag){
                System.out.println("two numbers is not found ");

            }
        }
    }
}
