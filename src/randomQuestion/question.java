package randomQuestion;


import java.util.*;

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.val = val;
		this.right = null;
		this.left = null;
	}
}

class ListNode {
	ListNode next;
	int val;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

class pair {
	int height;
	String name;


	public pair(int height, String name) {
		this.height = height;
		this.name = name;
	}
}

public class question {
	//pick and skip concept
	public void helper(int[] nums, List<List<Integer>> arr, List<Integer> temp, int i) {
		if (i == nums.length) {
			arr.add(new ArrayList<Integer>(temp));
			return;
		}
		temp.add(nums[i]);
		helper(nums, arr, temp, i + 1);
		temp.removeLast();
		helper(nums, arr, temp, i + 1);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> arr = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(nums, arr, temp, 0);
		return arr;
	}


	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		String str = new String();
		helperString(n, 0, ans, str);
		return ans;
	}

	private void helperString(int n, int i, List<String> ans, String str) {
		if (n == i) {
			for (int j = 1; j <= 2 * n - str.length(); j++) str = str + ")";
			ans.add(new String(str));
			return;
		}
		str = str + "(";
		helperString(n, i + 1, ans, str);
		str = str + ")";
		helperString(n, i + 1, ans, str);

	}


	public boolean checkDivisibility(int n) {
		List<Integer> arr = new ArrayList<>();
		int m = n;
		while (m > 0) {
			arr.add(m % 10);
			m = m / 10;
		}
		int sum = 0;
		int product = 1;
		for (int elem : arr) {
			sum += elem;
			product *= elem;
		}
		return n % (sum + product) == 0;
	}

	public static int strStr(String haystack, String need) {
		int n = haystack.length();
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			int j = 0;
			if (haystack.charAt(i) == need.charAt(j)) {
				int k = i;
				while (j < need.length()) {
					if (haystack.charAt(k) != need.charAt(j)) {
						j = 0;
						flag = false;
						break;

					}
					k++;
					j++;

				}
				if (flag) return i;
			}
		}
		return -1;

	}


	public static String[] sortPeople(String[] names, int[] heights) {
		int n = names.length;
		pair[] arr = new pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new pair(heights[i], names[i]);
		}
		Arrays.sort(heights);
		int x = 0;
		int y = n - 1;
		while (x < y) {
			int temp = heights[x];
			heights[x] = heights[y];
			heights[y] = temp;
			x++;
			y--;
		}
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].height == heights[j]) {
				names[j] = arr[i].name;
				i = -1;
				j++;
			}
			if (j == n) break;
		}
		return names;
	}

	public static int sqrt(int i, int j, int x) {
		if (j < i) return j;
		int mid = (i + j) / 2;
		if ((double) mid * mid == (double) x) return mid;
		if ((double) mid * mid < (double) x) return sqrt(mid + 1, j, x);
		return sqrt(i, mid - 1, x);
	}

	public static int mySqrt(int x) {
		return sqrt(0, x, x);
	}

	public String removeStars(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') st.pop();
			else st.push(s.charAt(i));
		}
		Stack<Character> st2 = new Stack<>();
		while (!st.isEmpty()) {
			st2.push(st.pop());
		}
		String ans = "";
		while (!st2.isEmpty()) {
			ans += st2.pop();
		}
		return ans;
	}


	//most logical and illogical code at the same the time 🤣🤣🤣🤣🤣🥹🥹🥹😆😆😆😆
	public static int GCD(int nums1, int nums2) {

		int min = Math.min(nums1, nums2);
		int max = Math.max(nums1, nums2);
		if (min == 0) return max;
		return GCD(max % min, min);
	}

	static ArrayList<Integer> leaders(int arr[]) {
		ArrayList<Integer> ans = new ArrayList<>();
		int right = arr.length - 1;
		int max = Integer.MIN_VALUE;
		while (right >= 0) {
			if (arr[right] > max) {
				ans.addFirst(arr[right]);
				max = arr[right];
			}
			right--;
		}

		return ans;

	}

	public int[] findErrorNums(int[] nums) {
		int[] ans = new int[2];
		HashSet<Integer> hs = new HashSet<>();
		int n = nums.length;
		int sum = (n * (n + 1)) / 2;
		int actualSum = 0;
		for (int i = 0; i < n; i++) actualSum += nums[i];
		int dup = 0;
		for (int i = 0; i < n; i++) {
			if (hs.contains(nums[i])) {
				dup = nums[i];
				break;
			} else hs.add(nums[i]);
		}
		ans[0] = dup;
		ans[1] = sum - (actualSum - dup);
		return ans;

	}

	public int firstMissingPositive(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) if (nums[i] > 0) hs.add(nums[i]);
		for (int i = 1; i - 1 < Integer.MAX_VALUE; i++) if (!hs.contains(i)) return i;
		return -1;
	}

	//3 fuction for the problem
	public static void inverse(int[] arr, int[] count) {
		int n = arr.length;
		if (n == 1) return;
		int[] arr1 = new int[n / 2];
		for (int i = 0; i < n / 2; i++) arr1[i] = arr[i];
		int[] arr2 = new int[n - n / 2];
		for (int i = 0; i < n - n / 2; i++) arr2[i] = arr[n / 2 + i];
		inverse(arr1, count);
		inverse(arr2, count);
		counting(arr1, arr2, count);

	}

	public static int inversionCount(int arr[]) {
		int[] count = {0};
		inverse(arr, count);
		return count[0];
	}

	public static void counting(int[] arr1, int[] arr2, int[] count) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i = 0;
		int j = 0;
		int num = 0;
		while (i < arr1.length) {
			while (j < arr2.length && arr1[i] > arr2[j]) {
				num++;
				j++;
			}
			count[0] += num;
			i++;
		}
	}

	//average solution with time complexity O(n2) and space complexity is O(n+triplet)
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		HashSet<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			HashSet<Integer> hs = new HashSet<>();
			for (int j = i + 1; j < nums.length; j++) {
				if (!hs.isEmpty() && hs.contains(-1 * (nums[i] + nums[j]))) {
					List<Integer> arr = new ArrayList<>();

					arr.add(nums[i]);
					arr.add(nums[j]);
					arr.add(-nums[i] - nums[j]);
					Collections.sort(arr);
					set.add(arr);
				}

			}
		}
		for (List<Integer> elem : set) ans.add(elem);
		return ans;
	}

	public List<List<Integer>> threeSumOptimalSol(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		int k = nums.length - 1;
		List<List<Integer>> ans = new ArrayList<>();
		while (i < nums.length) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				i++;
				continue;
			}
			List<Integer> arr = new ArrayList<>();
			int j = i + 1;
			while (j < i) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					arr.add(nums[i]);
					arr.add(nums[j]);
					arr.add(nums[k]);
					ans.add(arr);
					while (j < nums.length) {
						j++;
						if (nums[j] != nums[j - 1]) break;
					}
					while (k > j) {
						k--;
						if (nums[k] != nums[k - 1]) break;
					}
				} else if (nums[i] + nums[j] + nums[k] > 0) k--;
				else j++;
			}
			i++;
		}
		return ans;
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		String S = new String(arr);

		char[] arr2 = t.toCharArray();
		Arrays.sort(arr2);
		String T = new String(arr2);

		for (int i = 0; i < S.length(); i++) {
			if (T.charAt(i) != S.charAt(i)) return false;
		}
		return true;
	}

	public static String reverseWords(String s) {

		String[] arr = s.split(" ");
		int i = 0;
		int j = arr.length - 1;
		//change the order of the words
		while (i < j) {
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		//convert it from array to string again
		String str = "";
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == "") continue;
			str += arr[k];
			str += " ";
		}
		str = str.trim();

		return str;
	}

	static void main(String[] args) {
		System.out.println(reverseWords("a good   example"));
	}


}
