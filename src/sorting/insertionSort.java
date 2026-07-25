package sorting;

public class insertionSort {
    //insertion sort
    //idea come from playing card
    public static void main(String[] args) {
        int[] arr = {4,1,5,2,3};
        int n = arr.length;
        for( int i = 1 ; i<n ; i++){
            int current = arr[i];
            int pre = i-1;
            while(pre >= 0 && arr[pre]>current){
                arr[pre+1] = arr[pre];
                pre--;
            }
            arr[pre+1] = current;
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }



}
