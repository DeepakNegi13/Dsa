package array;

import java.util.ArrayList;
import java.util.Arrays;

public class commArr {
    public static void main(String[] args) {
        int[] nums1 = {1,23,23,45,7,7,7,7};
        int[] nums2 = {1,23,45,23,7,9};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> commArr = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i<nums1.length || j<nums2.length ){
            if(i<nums1.length && j<nums2.length){
                if(nums1[i]>nums2[j]) j++;
                else if (nums1[i]<nums2[j]) i++;
                else if(nums1[i]==nums2[j]) {
                    commArr.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            if(i>=nums1.length && j<nums2.length){
                if(nums1[i-1]==nums2[j]) {
                    commArr.add(nums2[j]);
                    break;
                }
                j++;
            }
            if(i<nums1.length && j>=nums2.length){
                if(nums1[i]==nums2[j-1]) {
                    commArr.add(nums2[i]);
                    break;
                }
                i++;
            }
        }
        for (int k = 0;k<commArr.size()-1;k++){
            if (commArr.get(k)==commArr.get(k+1)){
                commArr.remove(k+1);
            }
        }
//        for(int ele : commArr){
//            System.out.println(ele);
//        }
        System.out.println(commArr);
    }
}
