package TimeAndSpaceComplexity;

import java.sql.Array;
import java.util.Scanner;

public class duplicateElem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the value of n ");
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0 ;i<=n;i++){
            arr[i]= sc.nextInt();
        }
        //bruet force technique
//        boolean flag=false;
//        for (int i = 0;i<n;i++){
//            for (int j= i+1;j<=n;j++){
//                if (arr[i]==arr[j]){
//                    System.out.println(arr[i]);
//                    flag=true;
//                    break;
//                }
//            }
//            if (flag){
//                break;
//            }
//        }



        //
//        boolean[] found = new boolean[n+1];
//        int ele= 0;
//        for (int i= 0;i<=n;i++){
//            ele = arr[i];
//            if (found[arr[i]]==true){
//                System.out.println(arr[i]);
//            }else {
//                found[arr[i]]=true;
//            }
//        }



        //  most optimised techniques

        int sum = 0;
        for (int i = 0 ; i<=n;i++){
            sum=sum+arr[i];
        }
        int sum1ToN = n*(n+1)/2;
        System.out.println(sum-sum1ToN);
    }
}
