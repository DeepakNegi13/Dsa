package recursion;

public class binarySearch {
    public static int result(int[] arr,int target,int lo,int hi){
        if (lo>hi) return -1;
        if (arr[(hi+lo)/2]==target) return (hi+lo)/2;
        else if (arr[(hi+lo)/2]>target) return result(arr , target,lo,(hi+lo)/2-1);
        else  return result(arr , target,(hi+lo)/2+1,hi);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7,8,9};
        int target = 2;
        System.out.println(result(arr,target,0,arr.length-1));
    }
}
