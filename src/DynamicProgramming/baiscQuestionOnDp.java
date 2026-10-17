package DynamicProgramming;

public class baiscQuestionOnDp {
	public int fib(int n) {
		int[] dpArr = new int[n + 1];
		return fibHelper(n, dpArr);
	}

	private int fibHelper(int n, int[] dpArr) {
		if (n <= 1) return n;
		if (dpArr[n] != 0) return dpArr[n];
		dpArr[n] = fibHelper(n - 1, dpArr) + fibHelper(n - 2, dpArr);
		return dpArr[n];
	}

	public int climbStairs(int n) {
		int[] dpArr = new int[n + 1];
		return climbStairsHelper(n, dpArr);
	}

	private int climbStairsHelper(int n, int[] dpArr) {
		if (n <= 2) return n;
		if (dpArr[n] != 0) return dpArr[n];
		dpArr[n] = climbStairsHelper(n - 1, dpArr) + climbStairsHelper(n - 2, dpArr);
		return dpArr[n];
	}

	public static void main(String[] args) {

	}
}
