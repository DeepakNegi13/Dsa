package array;

import java.util.Arrays;
import java.util.Scanner;
//array is the (reference variable /address contain) .not a array name
public class maxElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }


//        int[] deep = Arrays.copyOf(arr,arr.length);
//        System.out.println(deep[1]);
        // doosra array ban gya
//        int[] x=arr;   doosra array nahi bana kyuki arr bus ak reference address hai or ab arr or x dono same array ke address k denote kar rahe hai

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        System.out.println(max);
        System.out.println(min);

    }

}
