package array;

import java.util.Arrays;
import java.util.Scanner;

public class rotateArr {
    public static void rev(int[] arr,int start,int end) {

        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }


    }
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("enter rotation number ");
        int r = sc.nextInt();
        r=r%n;


        //rotation
        rev(arr,0,r-1);
        rev(arr,r,n-1);
        rev(arr,0,n-1);

        //output
        for (int i = 0;i<n;i++){
        System.out.print(arr[i]+" ");
        }


//        int[] temp = Arrays.copyOf(arr,n);
//        for (int i = 0;i<n;i++){
//            if (i>=r){
//                arr[i-r]=temp[i];
//            }else {
//                arr[n+i-r]=temp[i];
//            }
//        }
//        for (int i = 0;i<n;i++){
//            System.out.print(arr[i]+" ");
//        }


    }
}
