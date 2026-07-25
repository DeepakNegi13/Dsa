package sorting;
//time complexity --> nlog(n)
//divide and concur
//step1 make two empty arrays of size half or original array
//step2 fill the elements like original and in case of odd size add 1 size to either first or second

public class mergeSort {
    public static void print(int[] nums){
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] nums){
        int[] nums1 = new int[nums.length/2];
        int[] nums2 = new int[nums.length-nums1.length];
        if(nums.length>1) {
            mergeSort(nums1);
            mergeSort(nums2);
            int i = 0;
            int j = 0;
            int k = 0;
            while (k < nums.length && i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    nums[k] = nums1[i];
                    k++;
                    i++;
                } else {
                    nums[k] = nums2[j];
                    j++;
                    k++;
                }
            }
            if (i == nums1.length - 1) {
                while (j < nums.length) {
                    nums[k] = nums2[j];
                    k++;
                    j++;
                }
            }
            else{
                while (i < nums.length) {
                    nums[k] = nums1[i];
                    k++;
                    i++;
                }
            }
        }else{
            nums = nums2;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,3,2,4,8,5,5,6,7,7,6,5,8,4,5,6,55,98};
        mergeSort(nums);
        print(nums);

    }


}
