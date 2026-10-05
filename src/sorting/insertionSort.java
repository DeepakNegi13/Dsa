package sorting;

public class insertionSort {
	//insertion sort(insert the element from a non sorted part to sorted part)
	public static void insertion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int pre = i - 1;
			while (pre >= 0 && arr[pre] > current) {
				arr[pre + 1] = arr[pre];
				pre--;
			}
			arr[pre + 1] = current;
		}
	}

	//idea come from playing card
	public static void main(String[] args) {
		int[] arr = {1, 3, 7, 4, 2, 8, 9, 5, 3, 6, 5, 4, 6, 0, 0, 7, 7, 7, 9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 3, 4, 5, 2, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8, 8, 7, 6, 5, 4, 3, 2, 3, 3, 4, 5, 6, 6, 7, 9, 9, 0, 7, 1, 5, 3, 6, 5, 5, 7, 8, 7, 9, 8, 7, 7, 6, 7, 6, 6, 6, 6, 6, 5, 4, 4, 3, 3, 3, 4, 4, 5, 6, 6, 3, 7, 8, 7, 6, 6, 5, 5, 6, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0, 8, 8, 7, 8, 7, 7, 7, 6, 6, 6, 6, 7, 5, 5, 4, 4, 3, 3, 5, 5, 6, 7, 7, 7, 6, 6, 6, 6, 6, 6, 12};
		insertion(arr);
		for (int elem : arr) System.out.print(elem + " ");
	}


}
