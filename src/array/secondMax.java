package array;
import java.util.Arrays;
import java.util.Scanner;
public class secondMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int max=Integer.MIN_VALUE;
        int _2ndmax = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        for (int i=0;i<arr.length;i++){
            if(arr[i]!=max){
                _2ndmax = Math.max(_2ndmax,arr[i]);
            }
        }
        System.out.println(_2ndmax);
    }
}
