package array;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class sortArrBuiltIn {
    public static int print(int[] arr){
        for(int i = 0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,78,96,23,3};
        print(arr);
        System.out.println("\n");
        Arrays.sort(arr);
        print(arr);

    }
}
