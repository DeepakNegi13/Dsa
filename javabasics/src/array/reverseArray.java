package array;

import java.util.Scanner;

public class reverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int n =arr.length;
        for (int i = 0; i <n; i++) {
            arr[i] = sc.nextInt();
        }
//        int[] revarr = new int[10];
//        for (int i=0;i<n;i++){
//            revarr[i]=arr[n-i-1];
//        }
//
//        arr=revarr;
//        for (int i=0;i<n;i++){
//            System.out.print(arr[i]+" ");
//        }

        // by two pointers technique
        int start = 0,end=arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        for (int i = 0; i <n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
