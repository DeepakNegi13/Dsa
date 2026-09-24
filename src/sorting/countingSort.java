package sorting;

public class countingSort {
	public static void countingSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		//find length of the main array
		int n = arr.length;
		//find max value
		for (int i = 0; i < n; i++) max = Math.max(max, arr[i]);
		//make copy array for hashing of length of max element+1
		int[] count = new int[max + 1];

		//count number of appearence of the element and store it in count array
		for (int i = 0; i < n; i++) count[arr[i]]++;

		//setting the index for the element is ended
		for (int i = 1; i < max + 1; i++) count[i] = count[i] + count[i - 1];

		int[] ans = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			count[arr[i]]--;
			ans[count[arr[i]]] = arr[i];
		}

		for (int i = 0; i < ans.length; i++) arr[i] = ans[i];


	}

	static void main(String[] args) {
		int[] arr = {1, 3, 7, 4, 2, 8, 9, 5, 3, 6, 5, 4, 6, 0, 0, 7, 7, 7, 9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 3, 4, 5, 2, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8, 8, 7, 6, 5, 4, 3, 2, 3, 3, 4, 5, 6, 6, 7, 9, 9, 0, 7, 1, 5, 3, 6, 5, 5, 7, 8, 7, 9, 8, 7, 7, 6, 7, 6, 6, 6, 6, 6, 5, 4, 4, 3, 3, 3, 4, 4, 5, 6, 6, 3, 7, 8, 7, 6, 6, 5, 5, 6, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0, 8, 8, 7, 8, 7, 7, 7, 6, 6, 6, 6, 7, 5, 5, 4, 4, 3, 3, 5, 5, 6, 7, 7, 7, 6, 6, 6, 6, 6, 6, 12};
		countingSort(arr);
		for (int elem : arr) System.out.print(elem + " ");
	}
}
