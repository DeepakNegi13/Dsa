package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class basicBacktracking {
	void ratInAMaze4D(int sr, int sc, int er, int ec, String s, boolean[][] isVisited) {
		if (sr < 0 || sc < 0) return;
		if (sr > er || sc > ec) return;
		if (isVisited[sr][sc]) return;
		if (sr == er && sc == ec) {
			System.out.println(s);
			return;
		}


		isVisited[sr][sc] = true;
		//right
		ratInAMaze4D(sr, sc + 1, er, ec, s + 'R', isVisited);
		//left
		ratInAMaze4D(sr, sc - 1, er, ec, s + 'L', isVisited);
		//down
		ratInAMaze4D(sr + 1, sc, er, ec, s + 'D', isVisited);
		//up
		ratInAMaze4D(sr - 1, sc, er, ec, s + 'U', isVisited);
		isVisited[sr][sc] = false;
	}

	void ratInA_2D_DeadMaze(int sr, int sc, int er, int ec, String s, int[][] deadSpot) {
		//0 means cant enter at that point and 1 mean can enter
		if (sr > er || sc > ec) return;
		if (deadSpot[sr][sc] == 0) return;
		if (sr == er && sc == ec) {
			System.out.println(s);
			return;
		}
		//right
		ratInA_2D_DeadMaze(sr, sc + 1, er, ec, s + 'R', deadSpot);
		//down
		ratInA_2D_DeadMaze(sr + 1, sc, er, ec, s + 'D', deadSpot);
	}

	void ratInA_4D_DeadMaze(int sr, int sc, int er, int ec, String s, int[][] deadSpot) {
		//0 means cant enter at that point 1 means can enter and -1 means already enter
		if (sr < 0 || sc < 0) return;
		if (sr > er || sc > ec) return;
		if (deadSpot[sr][sc] == 0 || deadSpot[sr][sc] == -1) return;
		if (sr == er && sc == ec) {
			System.out.println(s);
			return;
		}
		deadSpot[sr][sc] = -1;
		//right
		ratInA_4D_DeadMaze(sr, sc + 1, er, ec, s + 'R', deadSpot);
		//left
		ratInA_4D_DeadMaze(sr, sc - 1, er, ec, s + 'L', deadSpot);
		//down
		ratInA_4D_DeadMaze(sr + 1, sc, er, ec, s + 'D', deadSpot);
		//up
		ratInA_4D_DeadMaze(sr - 1, sc, er, ec, s + 'U', deadSpot);
		deadSpot[sr][sc] = 1;
	}

	void ratInAMaze2D(int row, int column, ArrayList<ArrayList<Character>> paths, ArrayList<Character> path) {
		if (row == 1 && column == 1) paths.add(new ArrayList<>(path));
		if (row > 1) {
			path.add('D');
			ratInAMaze2D(row - 1, column, paths, path);
			path.removeLast();
		}
		if (column > 1) {
			path.add('R');
			ratInAMaze2D(row, column - 1, paths, path);
			path.removeLast();
		}
	}

	int numberOfPathInMaze(int row, int column) {
		if (row == 1 || column == 1) return 1;
		return numberOfPathInMaze(row - 1, column) + numberOfPathInMaze(row, column - 1);
	}

	public static void permutate(List<Integer> nums, List<List<Integer>> permuatations, List<Integer> permutation, int size) {
		if (permutation.size() == size) {
			permuatations.add(new ArrayList<>(permutation));
			return;
		}

		for (int j = 0; j < nums.size(); j++) {
			//take
			permutation.add(nums.get(j));
			int removeVal = nums.remove(j);
			permutate(nums, permuatations, permutation, size);

			//not take
			permutation.removeLast();
			nums.add(j, removeVal);
		}

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> permutation = new ArrayList<>();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) arr.add(nums[i]);
		permutate(arr, permutations, permutation, nums.length);

		for (List<Integer> elems : permutations) {
			for (int elem : elems) System.out.print(elem + " ");
			System.out.println();
		}
		return permutations;
	}

	public static void permutate2(int[] nums, List<List<Integer>> permuatations, List<Integer> permutation, int size, boolean[] isVisited) {
		if (permutation.size() == size) {
			permuatations.add(new ArrayList<>(permutation));
			return;
		}

		for (int j = 0; j < nums.length; j++) {
			//take
			if (!isVisited[j]) {
				permutation.add(nums[j]);
				isVisited[j] = true;
				permutate2(nums, permuatations, permutation, size, isVisited);

				//not take
				permutation.removeLast();
				isVisited[j] = false;
			}


		}

	}

	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> permutation = new ArrayList<>();
		boolean[] isvisited = new boolean[nums.length];
		permutate2(nums, permutations, permutation, nums.length, isvisited);

		for (List<Integer> elems : permutations) {
			for (int elem : elems) System.out.print(elem + " ");
			System.out.println();
		}
		return permutations;
	}

	//give all the solution
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		List<List<String>> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) board[i][j] = '.';
		nqueens(board, 0, ans);
		return ans;
	}

	private void nqueens(char[][] board, int row, List<List<String>> ans) {

		int n = board.length;
		if (row == n) {
			List<String> string = new ArrayList<>();
			for (int k = 0; k < n; k++) {
				String str = "";
				for (int l = 0; l < n; l++) {
					str = str + board[k][l];
				}
				string.add(str);
			}
			ans.add(string);
			return;
		}
		for (int j = 0; j < n; j++) {
			if (isSafeSpot(board, row, j)) {
				board[row][j] = 'Q';
				nqueens(board, row + 1, ans);
				board[row][j] = '.';
			}
		}


	}

	private boolean isSafeSpot(char[][] board, int row, int column) {
		int n = board.length;

		//check row
		for (int j = 0; j < n; j++) {
			if (board[row][j] == 'Q') return false;
		}
		//check column
		for (int i = 0; i < n; i++) {
			if (board[i][column] == 'Q') return false;
		}

		//check diagonal
		//mark a executing spot
		int i = row;
		int j = column;
		//for north east side
		while (j < n && i >= 0) {
			if (board[i][j] == 'Q') return false;
			j++;
			i--;
		}
		//variable take to the main position
		i = row;
		j = column;
		//for north west side
		while (j >= 0 && i >= 0) {
			if (board[i][j] == 'Q') return false;
			j--;
			i--;
		}

		//variable take to the main position
		i = row;
		j = column;
		//for south east side
		while (j < n && i < n) {
			if (board[i][j] == 'Q') return false;
			j++;
			i++;
		}
		//variable take to the main position
		i = row;
		j = column;
		//for south west side
		while (j >= 0 && i < n) {
			if (board[i][j] == 'Q') return false;
			j--;
			i++;
		}
		return true;
	}

	//give total number of solution
	public int totalNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) board[i][j] = '.';
		int[] num = new int[1];
		nqueensNumber(board, 0, num);
		return num[0];
	}

	private void nqueensNumber(char[][] board, int row, int[] num) {

		int n = board.length;
		if (row == n) {
			num[0]++;
			return;
		}
		for (int j = 0; j < n; j++) {
			if (isSafeSpot(board, row, j)) {
				board[row][j] = 'Q';
				nqueensNumber(board, row + 1, num);
				board[row][j] = '.';
			}
		}


	}


	void main() {
		/*ArrayList<ArrayList<Character>> paths = new ArrayList<>();
		ArrayList<Character> path = new ArrayList<>();
		//System.out.println(numberOfPathInMatrix(10, 10));
		printPaths(12, 12, paths, path);
		int i = 1;
		for (ArrayList<Character> elem : paths) {
			for (Character elem2 : elem) System.out.print(elem2 + " ");
			System.out.println();
		}*/

		/*int er = 3;
		int ec = 3;
		boolean[][] isVisited = new boolean[er][ec];
		printPathsIn4Dir(0, 0, er - 1, ec - 1, "", isVisited);*/

		int[] arr = {1, 2, 3};
		permute(arr);

	}
}
