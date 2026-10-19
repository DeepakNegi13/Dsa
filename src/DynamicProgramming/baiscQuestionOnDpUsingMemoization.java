package DynamicProgramming;

public class baiscQuestionOnDpUsingMemoization {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] min = new int[1];
		int sum = 0;
		int[][] dp = new int[m][n];
		return minPathSumHelper(grid, sum, 0, 0, dp);

	}

	private int minPathSumHelper(int[][] grid, int sum, int row, int column, int[][] dp) {
		if (row == grid.length - 1) {
			for (int i = column; i < grid[0].length; i++) {
				sum += grid[row][i];
			}
			return sum;
		}
		if (column == grid[0].length - 1) {
			for (int i = row; i < grid.length; i++) {
				sum += grid[i][column];
			}
			return sum;
		}
		if (dp[row][column] != 0) return dp[row][column];
		dp[row][column] = Math.min(minPathSumHelper(grid, sum + grid[row][column], row + 1, column, dp),
				minPathSumHelper(grid, sum + grid[row][column], row, column + 1, dp));
		return dp[row][column];
	}

	//dearrangement question alternate solution --> use direct mathematical formula
	public int derangeCount(int n) {
		int[] dp = new int[n];
		return derangeCountHelper(n, dp);
	}

	private int derangeCountHelper(int n, int[] dp) {
		if (n == 1) return 0;
		if (n == 2) return 1;
		if (dp[n - 1] != 0) return dp[n - 1];
		dp[n - 1] = (n - 1) * (derangeCount(n - 1) + derangeCount(n - 2));
		return dp[n - 1];
	}

	/*Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.*/
	public int countFriendsPairings(int n) {
		int[] dp = new int[n];

		return countFriendsPairingsHelper(n, dp);
	}

	private int countFriendsPairingsHelper(int n, int[] dp) {
		if (n <= 2) return n;
		if (dp[n - 1] != 0) return dp[n - 1];
		dp[n - 1] = countFriendsPairingsHelper(n - 1, dp) + (n - 1) * countFriendsPairingsHelper(n - 2, dp);
		return dp[n - 1];
	}


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
