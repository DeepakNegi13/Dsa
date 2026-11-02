package array;

import java.util.Scanner;

public class sumOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        int pro = 1;
        for (int i = 0; i < len; i++) {
            sum = sum+arr[i];
            pro = pro *arr[i];
        }
        System.out.println(sum);
        System.out.println(pro);
    }

}
