package randomQuestion;

import java.math.BigInteger;
import java.util.*;

class pair {
	int height;
	String name;


	public pair(int height, String name) {
		this.height = height;
		this.name = name;
	}
}

public class question {
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


	static void main(String[] args) {
		System.out.println(GCD(24, 60));
	}


}
