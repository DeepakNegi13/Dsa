package array;

public class waveArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,56,78,89,90};
        int n = arr.length;
        for (int i = 0;i<n-1 ;i+=2){
            int temp = arr[i+1];
            arr[i+1] = arr[i];
            arr[i] = temp;
        }
        for (int k = 0 ;k<n ;k++){
            System.out.print(arr[k]+" ");
        }
    }

}
