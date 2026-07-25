package recursion;
import java.util.Scanner;


public class recursionOnArray {
    public static void print(int[] arr,int n){
        if (n==0) return;
        print(arr,n-1);
        System.out.print(arr[n-1]+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter length of array ");
        int n = sc.nextInt();
        System.out.print("enter element of array ");
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
             arr[i] = sc.nextInt();
        }

        print(arr,n);

    }
}
