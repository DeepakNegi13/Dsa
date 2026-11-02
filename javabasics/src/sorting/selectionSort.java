package sorting;

public class selectionSort {
	// selection sort
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			//assuming the minimum value is in the index where I stand
			int min = arr[i];
			int idx = i;
			//finding out is there is any index whose value is smaller than our assuming value
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					idx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;

		}
	}

	static void main(String[] args) {
		int[] arr = {1, 3, 7, 4, 2, 8, 9, 5, 3, 6, 5, 4, 6, 0, 0, 7, 7, 7, 9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 3, 4, 5, 2, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8, 8, 7, 6, 5, 4, 3, 2, 3, 3, 4, 5, 6, 6, 7, 9, 9, 0, 7, 1, 5, 3, 6, 5, 5, 7, 8, 7, 9, 8, 7, 7, 6, 7, 6, 6, 6, 6, 6, 5, 4, 4, 3, 3, 3, 4, 4, 5, 6, 6, 3, 7, 8, 7, 6, 6, 5, 5, 6, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0, 8, 8, 7, 8, 7, 7, 7, 6, 6, 6, 6, 7, 5, 5, 4, 4, 3, 3, 5, 5, 6, 7, 7, 7, 6, 6, 6, 6, 6, 6, 12};
		selectionSort(arr);
		for (int elem : arr) System.out.print(elem + " ");
	}


}
