package Backtracking;

import java.util.ArrayList;

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
		if (sr > er || sc > ec) return;
		if (deadSpot[sr][sc] == 1) return;
		if (sr == er && sc == ec) {
			System.out.println(s);
			return;
		}
		//right
		ratInA_2D_DeadMaze(sr, sc + 1, er, ec, s + 'R', deadSpot);
		//down
		ratInA_2D_DeadMaze(sr + 1, sc, er, ec, s + 'D', deadSpot);
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

		int[][] deadSpot = new int[3][3];
		deadSpot[2][0] = 1;
		deadSpot[2][1] = 1;
		ratInA_2D_DeadMaze(0, 0, 2, 2, "", deadSpot);


	}
}
