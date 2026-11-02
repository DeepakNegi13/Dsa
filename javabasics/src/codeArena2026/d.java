package codeArena2026;

import java.util.Scanner;

public class d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0;j < n/2;j++){
                a[j] = 1;
                a[n-j-1] = -1;
            }
            for(int ele : a){
                System.out.print(ele+" ");
            }
            System.out.println();
        }

    }
}
