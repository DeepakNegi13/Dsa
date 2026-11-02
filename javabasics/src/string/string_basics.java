package string;

import java.util.Scanner;

public class string_basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        String name = sc.nextLine();
        int count = 0;
        for (int i = 0;i<name.length();i++){
            if (name.charAt(i)=='a'||name.charAt(i)=='e'||name.charAt(i)=='i'||name.charAt(i)=='o'||name.charAt(i)=='u'||name.charAt(i)=='A'||name.charAt(i)=='I'||name.charAt(i)=='O'||name.charAt(i)=='U'||name.charAt(i)=='E'){
                count++;
            }
        }
        System.out.println(count);
    }
}

