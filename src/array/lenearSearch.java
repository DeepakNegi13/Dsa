package array;

import java.util.Scanner;

public class lenearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("enter search element ");
        int target = sc.nextInt();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++){
            if (target==arr[i]){
                System.out.println("target exist");
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("target does not exist ");
        }
    }
}
