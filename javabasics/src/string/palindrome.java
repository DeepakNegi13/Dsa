package string;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int i = 0,j = n-1;
        boolean palindrome = true;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                palindrome = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println(palindrome);






//        int count= 0;
//        for (int i = 0;i<n/2;i++){
//            if (s.charAt(i)==s.charAt(n-1-i)){
//                count++;
//            }
//            if (count==n/2){
//                System.out.println("this is a palindrome");
//            }
//        }
    }
}
