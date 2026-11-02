package array;

import java.util.Scanner;

public class search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("enter search element ");
        int x = sc.nextInt();
        for (int i = 0; i < arr.length; i++){
            if (x==arr[i]){
                System.out.println("index of "+ x + " is = "+i);
            }
        }
    }
}
