package sorting;

public class raddixSort {
	private static void sort(int[] arr, int pos) {
		int[] count = new int[10];
		for (int i = 0; i < arr.length; i++) {
			count[(arr[i] / pos) % 10]++;
		}
		for (int i = 1; i < 10; i++) count[i] += count[i - 1];
		int[] copy = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			copy[--count[(arr[i] / pos) % 10]] = arr[i];
		}
		for (int i = 0; i < copy.length; i++) arr[i] = copy[i];
	}

	public static int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) max = Math.max(max, arr[i]);
		return max;
	}

	public static void raddixSort(int[] arr) {
		int max = getMax(arr);
		for (int pos = 1; max / pos > 0; pos *= 10) {
			sort(arr, pos);
		}
	}


	static void main(String[] args) {
		int[] arr = {19, 3, 700, 498, 2, 80, 980, 5, 34, 39765, 38, 3028, 328, 427, 5443, 255, 267};
		raddixSort(arr);
		for (int elem : arr) System.out.print(elem + " ");
	}
}
