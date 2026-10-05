package sorting;

public class quickSort {
	public static int pivot(int[] arr, int start, int end) {
		int i = start;
		int j = end;
		while (i < j) {
			while (i <= end && arr[i] <= arr[start]) i++;
			while (j >= start && arr[j] > arr[start]) j--;
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[j];
		arr[j] = arr[start];
		arr[start] = temp;

		return j;
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = pivot(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}

	}

	static void main(String[] args) {
		int[] arr = {1, 3, 7, 4, 2, 8, 9, 5, 3, 6, 5, 4, 6, 0, 0, 7, 7, 7, 9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 3, 4, 5, 2, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8, 8, 7, 6, 5, 4, 3, 2, 3, 3, 4, 5, 6, 6, 7, 9, 9, 0, 7, 1, 5, 3, 6, 5, 5, 7, 8, 7, 9, 8, 7, 7, 6, 7, 6, 6, 6, 6, 6, 5, 4, 4, 3, 3, 3, 4, 4, 5, 6, 6, 3, 7, 8, 7, 6, 6, 5, 5, 6, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0, 8, 8, 7, 8, 7, 7, 7, 6, 6, 6, 6, 7, 5, 5, 4, 4, 3, 3, 5, 5, 6, 7, 7, 7, 6, 6, 6, 6, 6, 6, 12};
		quickSort(arr, 0, arr.length - 1);
		for (int elem : arr) System.out.print(elem + " ");
	}

}
