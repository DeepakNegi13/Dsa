package recursion;

import java.util.ArrayList;
import java.util.List;

import static Queues.basicQueues.reverse;
import static java.util.Collections.swap;

public class Question {
	//print all the subscequences
	public static List<List<Integer>> subscequences(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		allSubscequences(arr, ans, temp, 0);
		return ans;
	}

	//subsequence helper function
	public static void allSubscequences(int[] arr, List<List<Integer>> ans, List<Integer> temp, int i) {
		if (i == arr.length) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		temp.add(arr[i]);
		allSubscequences(arr, ans, temp, i + 1);
		temp.removeLast();
		allSubscequences(arr, ans, temp, i + 1);
	}

	//check palindrome
	public static boolean isPalindrome(String st) {
		return palindrome(st, 0);
	}

	private static boolean palindrome(String st, int i) {
		if (i > st.length() / 2) return true;
		return (st.charAt(st.length() - 1 - i) == st.charAt(i)) && palindrome(st, i + 1);
	}

	//reverse the array
	public static void reverseArray(int[] arr) {
		reverse(arr, 0);
	}

	private static void reverse(int[] arr, int i) {
		if (i > arr.length - 1 - i) return;
		int temp = arr[i];
		arr[i] = arr[arr.length - 1 - i];
		arr[arr.length - 1 - i] = temp;
		reverse(arr, i + 1);
	}


	//factorial of n
	public static int fac(int n) throws Exception {
		if (n < 0) throw new Exception("AithematicExceptionNoValueFound");
		if (n == 1 || n == 0) return 1;
		return n * fac(n - 1);
	}

	//sum of n number
	public static int sumOfN(int n) {
		if (n == 0) return 0;
		return sumOfN(n - 1) + n;
	}

	//nth fibonacci number
	public static int nthFibonacci(int n) {
		if (n == 1) return 0;
		if (n == 2) return 1;
		return nthFibonacci(n - 1) + nthFibonacci(n - 2);
	}

	//sum of nth fibonacci number
	public static int sumOfNthFibonacci(int n) {
		if (n == 1) return 0;
		return sumOfNthFibonacci(n - 1) + nthFibonacci(n);
	}

	public static void main(String[] args) throws Exception {
		//0 1 1 2 3 5 8 13 21 34
		//System.out.println(sumOfNthFibonacci(5));
		int[] arr = {1, 2, 3, 4};
		List<List<Integer>> ans = subscequences(arr);
		for (List<Integer> elem : ans) {
			System.out.print("[ ");
			for (int val : elem) {
				System.out.print(val + " ");
			}
			System.out.println("]");
			System.out.println();
		}
	}
}
