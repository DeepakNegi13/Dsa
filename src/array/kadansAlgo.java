package array;

public class kadansAlgo {
    //KADANS ALOGORITHEM
    public static void main(String[] args) {
        int[] arr = {-1,-3,-5,-6,-7,-8,-9};
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            ans = Math.max(ans,sum);
            if(sum<0) sum=0;
        }
        System.out.println(ans);
    }
}
