package recursion;

public class RevOfArrUsingRec {
    public static int[] rev (int[] arr,int index,int n){
        if (index>=n) return arr;
        int temp = arr[index];
        arr[index] = arr[n-1];
        arr[n-1] = temp;
        return rev(arr,index+1,n-1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        int index = 0;
        int n = arr.length;
        rev(arr,index,n);
        for (int ele : arr){
            System.out.print(ele+" ");
        }
    }



}
