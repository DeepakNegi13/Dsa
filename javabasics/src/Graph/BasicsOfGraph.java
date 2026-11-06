package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicsOfGraph {
	public int findCircleNum(int[][] adj) {
		int n = adj.length;
		boolean[] flag = new boolean[n];
		int ans = 0;
		for(int i = 0;i<n;i++){
			if (!flag[i]) {
				flag[i] = true;
				bfs(adj, flag, n, i);
				ans++;
			}
		}
		return ans;
	}

	private void bfs(int[][] adj, boolean[] flag,int n,int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		while (!q.isEmpty()){
			int k = q.remove();
			for (int j = 0;j<n;j++) if (adj[k][j]==1 && !flag[j]) {
				q.add(j);
				flag[j] = true;
			}
		}
	}

	public static void main(String[] args) {

	}
}
