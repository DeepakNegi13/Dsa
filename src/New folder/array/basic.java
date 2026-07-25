package array;

import java.util.ArrayList;
import java.util.Arrays;

public class basic {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean flag = false;
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]==nums[j]&&Math.abs(i-j)<=k){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        return flag;


    }

    static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        String str = "hello" ;
        str.toUpperCase();
        System.out.println(str);
        int[] copyArr = Arrays.copyOf(arr,arr.length);
        arr = Arrays.copyOf(copyArr,copyArr.length);
    }
}
