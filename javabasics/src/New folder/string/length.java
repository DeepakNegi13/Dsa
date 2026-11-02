package string;

import java.util.Arrays;

public class length {

    static int length(String str){
        char[] arr = str.toCharArray();
        int count = 0;
        for(int ele:arr){
            count++;
        }
        return count;
    }
    static String reverse(String str){
//        String reverseStr = "";
        for(int x = 0; x <str.length()/2;x++){
            char duplicate = str.charAt(str.length()-1-x);
            str.replace(str.charAt(x),str.charAt(str.length()-x-1));
            str.replace(str.charAt(str.length()-1-x),duplicate);
        }
        return str;
    }
//    public boolean isPalindrome(String st) {
//        st.toLowerCase();
//        st.trim(" ");
//        st.formatted();
//
//        return true;
//    }
public void sortInWave(int arr[]) {
    // code here
    int i = 0;
    int j = 1;
    while(j< arr.length){
        int swap = arr[i];
        arr[i]=arr[j];
        arr[j]=swap;
        j += 2;
        i += 2;
    }
}
    static void main(String[] args) {
        String str = "deepak";
        str = reverse(str);
        System.out.println(str);




    }
}
