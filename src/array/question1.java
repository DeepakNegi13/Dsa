package array;

import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr=new int[10];
        for (int i = 0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        for (int i = 0;i<arr.length;i++){
            if(i%2==0){
                arr[i]=arr[i]+10;
            }else {
                arr[i]=2*arr[i];
            }
            System.out.print(arr[i]+" ");
        }
    }
}
