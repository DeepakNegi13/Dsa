package array;

import java.util.*;

public class questionFunctionStriverSheet {

    //Largest element
    static int largestElement(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }

    //Second largest element
    static int secondLargestElement(int[] arr) {

        int n = arr.length;
        //  better approach then brute force
//        int largest = Integer.MIN_VALUE;
//        for(int i = 0;i<arr.length;i++){
//            largest = Math.max(largest,arr[i]);
//        }
//        int secondLargest = Integer.MIN_VALUE;
//        for(int i = 0;i<arr.length;i++){
//            if(arr[i]!=largest){
//                secondLargest = Math.max(arr[i],secondLargest);
//            }
//
//        }
//        //in case their is no second largest then return -1
//        if(secondLargest==Integer.MIN_VALUE) secondLargest = -1;
//        return secondLargest;

        //optimal approach
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }

        }
        if (secondLargest == largest) secondLargest = -1;
        return secondLargest;

    }

    //Missing Number
    //Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), return the only number missing from the array within this range.
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int elem : nums) {
            sum += elem;
        }
        int sumOfnNumber = (n * (n + 1)) / 2;
        return sumOfnNumber - sum;
    }

    //union of two sorted arrays
    public List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        // List to store union elements
        List<Integer> Union = new ArrayList<>();

        // Initialize pointers
        int i = 0, j = 0;

        // Iterate while both arrays have elements
        while (i < n && j < m) {
            // If element in arr1 is smaller
            if (arr1[i] < arr2[j]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;  // Move pointer in arr1
            }
            // If element in arr2 is smaller
            else if (arr2[j] < arr1[i]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;  // Move pointer in arr2
            } else {
                // Elements are equal, add once if not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
                j++;  // Move both pointers
            }
        }

        // Append remaining elements from arr1
        while (i < n) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        // Append remaining elements from arr2
        while (j < m) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }

        // Return the union list
        return Union;
    }

    //maximum subarray sum equal to k
    //Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        int iteration = 0;
        int start = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            iteration++;


            if(sum == k){
                max = Math.max(max,iteration);
            }
            if(sum > k){
                iteration = 0;
                i = start;
                start++;
                sum = 0;
            }

        }
        return max;

    }

//    Given an integer array nums, return a list of all the leaders in the array.
//    A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.
    public List<Integer> leaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int i = n-1;
        int max = nums[n-1];
        while(i>=0) {
            max = Math.max(nums[i], max);
            if (nums[i] == max) {
                ans.add(max);
            }
            i--;
        }
        int start = 0;
        int end = ans.size()-1;
        while(start<end){
            int swap = ans.get(start);
            ans.set(start,ans.get(end));
            ans.set(end,swap);
        }
        return ans;
    }

    public  static int longestConsecutive(int[] nums) {
        ArrayList<Integer> map = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            map.set(num, 1);
        }


        int count = 0;
        int max = 0;
        int m = map.size();
        for(int i = 1;i<m;i++){
            if(map.get(i)==1){
                count++;
                max = Math.max(count,max);
            }else count = 0;
        }
        return max;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(top>=bottom){
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right++;
            for(int i=right;i>=left;i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                ans.add(matrix[i][left]);
            }
            left--;
        }
        
        return ans;
    }

    static void main(String[] args) {
        String str = "csvbcsggcdj";
//        str.charAt()
//        Arrays.sort;
        System.out.println(Math.powExact(1,3));
        int[] arr = {-1, 1, 1,1,3,5,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0};
        System.out.println(longestSubarray(arr,4));
        System.out.println(longestConsecutive(arr));
    }
}
