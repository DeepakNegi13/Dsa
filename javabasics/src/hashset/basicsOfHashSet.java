package hashset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class basicsOfHashSet {
	static int countDistinct(int arr[]) {
		// code here
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (!hs.contains(arr[i])) hs.add(arr[i]);
		}
		return hs.size();
	}


	//get value
	public static int[] twoSumValue(int[] nums, int target) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(target - nums[i])) {
				int[] ans = {nums[i], target - nums[i]};
				return ans;
			}
			hs.add(nums[i]);
		}
		int[] ans2 = {};

		return ans2;
	}

	//check two sum
	public static boolean ChecktwoSum(int[] nums, int target) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(target - nums[i])) return true;
			else hs.add(nums[i]);
		}
		return false;

	}

	public List<Integer> findMissingElements(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (!hs.contains(nums[i])) hs.add(nums[i]);
			min = Math.min(nums[i], min);
			max = Math.max(nums[i], max);
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = min + 1; i < max; i++) {
			if (!hs.contains(i)) ans.add(i);
		}
		return ans;


	}

	public static void main(String[] args) {
		//unordered set generally time complexity for  searching adding deleting is O(1)
		HashSet<Integer> hs = new HashSet<>();


	}
}
