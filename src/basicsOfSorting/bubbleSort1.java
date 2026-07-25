package basicsOfSorting;

import java.util.Scanner;

public class bubbleSort1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter array size ");
        int n = sc.nextInt();
        System.out.println("enter array elemente ");
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }


        for (int i = 1;i<n;i++) {
            for (int j = 0; j < n-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[i];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        for (int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
