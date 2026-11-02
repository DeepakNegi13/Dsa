package array;

import java.util.Scanner;

public class intOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr= new int[7];
        int len = arr.length;
        for (int i=0;i<len;i++){
            arr[i]= sc.nextInt();
        }
        for (int i = 0;i<len;i++){
            if (arr[i]<0){
                System.out.println(arr[i]);
            }
        }
    }
}
