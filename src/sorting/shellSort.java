package sorting;

public class shellSort {
	public static void shellSort(int[] arr) {
		int gap = arr.length / 2;
		while (gap > 0) {
			for (int j = gap; j < arr.length; j++) {
				for (int i = j - gap; i >= 0; i = i - gap) {
					if (arr[i] < arr[i + gap]) break;
					else {
						int temp = arr[i];
						arr[i] = arr[i + gap];
						arr[i + gap] = temp;
					}
				}
			}
			gap /= 2;
		}
	}

	static void main(String[] args) {
		int[] arr = {1, 3, 7, 4, 2, 8, 9, 5, 3, 6, 5, 4, 6, 0, 0, 7, 7, 7, 9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 3, 4, 5, 2, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8, 8, 7, 6, 5, 4, 3, 2, 3, 3, 4, 5, 6, 6, 7, 9, 9, 0, 7, 1, 5, 3, 6, 5, 5, 7, 8, 7, 9, 8, 7, 7, 6, 7, 6, 6, 6, 6, 6, 5, 4, 4, 3, 3, 3, 4, 4, 5, 6, 6, 3, 7, 8, 7, 6, 6, 5, 5, 6, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0, 8, 8, 7, 8, 7, 7, 7, 6, 6, 6, 6, 7, 5, 5, 4, 4, 3, 3, 5, 5, 6, 7, 7, 7, 6, 6, 6, 6, 6, 6, 12};
		shellSort(arr);
		for (int elem : arr) System.out.print(elem + " ");
	}
}
