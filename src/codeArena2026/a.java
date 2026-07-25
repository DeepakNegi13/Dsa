package codeArena2026;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += a[j];
                if(sum>=k*(j-i+1)){
                    max = Math.max(max,sum);
                    max1 = Math.max(max1,(j-i+1));
                }
            }
        }
        System.out.println(max1);



    }
}
