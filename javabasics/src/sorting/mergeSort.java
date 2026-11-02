package sorting;
//time complexity --> nlog(n)
//divide and concur
//step1 make two empty arrays of size half or original array
//step2 fill the elements like original and in case of odd size add 1 size to either first or second

public class mergeSort {
	public static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;
		int[] arr2 = new int[end - start + 1];
		while (j <= end && i <= mid) {
			if (arr[i] <= arr[j]) arr2[k++] = arr[i++];
			else arr2[k++] = arr[j++];
		}
		while (i <= mid) arr2[k++] = arr[i++];
		while (j <= end) arr2[k++] = arr[j++];
		for (int elem : arr2) arr[start++] = elem;
	}

	//time complexity (O(nlog(N)))
	public static void mergeSort(int[] arr, int start, int end) {
		if (start == end) return;
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, mid, end);


	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 7, 4, 2, 8, 9, 5, 3, 6, 5, 4, 6, 0, 0, 7, 7, 7, 9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 3, 4, 5, 2, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8, 8, 7, 6, 5, 4, 3, 2, 3, 3, 4, 5, 6, 6, 7, 9, 9, 0, 7, 1, 5, 3, 6, 5, 5, 7, 8, 7, 9, 8, 7, 7, 6, 7, 6, 6, 6, 6, 6, 5, 4, 4, 3, 3, 3, 4, 4, 5, 6, 6, 3, 7, 8, 7, 6, 6, 5, 5, 6, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0, 8, 8, 7, 8, 7, 7, 7, 6, 6, 6, 6, 7, 5, 5, 4, 4, 3, 3, 5, 5, 6, 7, 7, 7, 6, 6, 6, 6, 6, 6, 12};
		mergeSort(nums, 0, nums.length - 1);
		print(nums);

	}


}
