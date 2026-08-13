package randomQuestion;

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
	public int strStr(String haystack, String need) {
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

	public String[] sortPeople(String[] names, int[] heights) {
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

	public int sqrt(int i, int j, int x) {
		if (j < i) return j;
		int mid = (i + j) / 2;
		if ((double) mid * mid == (double) x) return mid;
		if ((double) mid * mid < (double) x) return sqrt(mid + 1, j, x);
		return sqrt(i, mid - 1, x);
	}

	public int mySqrt(int x) {
		return sqrt(0, x, x);
	}


	public boolean containsNearbyDuplicate(int[] nums, int k) {

	}

	static void main(String[] args) {

	}


}
