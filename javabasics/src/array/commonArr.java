package array;

import java.util.Arrays;

public class commonArr {
    public static void main(String[] args) {
        int[] arr1 = {1,223,22,56,74,65,6,4,1,23,34,45,56};
        int[] arr2 = {1,23,22,56,75,65,6,66,1,24,34,45,57};
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j=0;
        while(i<n1 && j < n2){
            if (arr1[i]>arr2[j]){
                j++;
            }else if (arr1[i]<arr2[j]){
                i++;
            }else {
                System.out.print(arr1[i]+" ");
                i++;
                j++;
                n++;
            }
        }
    }
}
