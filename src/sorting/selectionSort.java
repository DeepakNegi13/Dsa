package sorting;

public class selectionSort {
    // selection sort
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0,1,2,3,43,4,6,7,8,9,7,6,5,5,4,3,32,2};
        int n = arr.length;
        int m = 0;
        for(int i = m;i<n;i++){
            int min = Integer.MAX_VALUE;
            int x = 0;
            for(int j = i;j<n;j++){
                min = Math.min(min,arr[j]);
                x = j;
            }
            int temp = arr[i];
            arr[i]= min;
            arr[x] = temp;
            m++;

        }
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }







}
