package basicsOfSorting;

import java.util.Scanner;

public class bubblesort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter array size ");
        int n = sc.nextInt();
        System.out.println("enter array elemente ");
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

//      buuble sort
//        for (int i = 0;i<n-1;i++) {
//            for (int j = 0; j < n-2-i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int swap = arr[i];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = swap;
//                }
//            }
//        }
        // bubble sort opytimised
//        for (int i = 0;i<n-1;i++) {
//            // for checking the array is sorted in between the program
//            boolean sort = true;
//            for (int i =1;i<arr.length;i++){
//                if(arr[i]<arr[i-1]){
//                    sort = false;
//                    break;
//                }
//            }
//            if (sort){
//                break;
//            }
//            for (int j = 0; j < n-2-i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int swap = arr[i];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = swap;
//                }
//            }
//        }


        // other optimised bubble sort
        for (int i = 0;i<n-1;i++) {
            int sorted = 1;
            for (int j = 0; j < n-2-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[i];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                    sorted++;
                }
            }
            if (sorted==1){
                break;
            }
        }

        for (int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
