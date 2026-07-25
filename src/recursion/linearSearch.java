package recursion;

public class linearSearch {
    public static boolean Search(int[] arr , int n,int target){
        if (n==0) return false;
        if (arr[n-1]==target)  return true;
        return Search(arr,n-1,target);

    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,4,5,6,7,8,9,0};
        int target = 99;
        System.out.println(Search(arr,arr.length,target));
    }
}
