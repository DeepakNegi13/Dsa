package array;

import java.util.Arrays;

public class checkSortedArr {
    public static void main(String[] args) {
        int[] arr ={1, 24 , 56,12 ,345 ,67,987, 98};
//        int[] copyOfArr = Arrays.copyOf(arr,arr.length);
//        if (arr == copyOfArr){
//            System.out.println("array is sorted ");
//        }else{
//            System.out.println("array is not sorted ");
//        }

        boolean sort = true;
        for (int i =1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                sort = false;
                break;
            }
        }
        if (sort){
            System.out.println("array is sorted already");
        }else {
            System.out.println("array is not sorted");
        }

    }






}
