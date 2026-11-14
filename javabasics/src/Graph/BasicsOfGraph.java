package Graph;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BasicsOfGraph {

	// leetcode 547
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

	//leetcode 841
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] checkedRooms = new boolean[rooms.size()];
		Queue<List<Integer>> q = new LinkedList<>();
		q.add(rooms.get(0));
		checkedRooms[0] = true;
		while(!q.isEmpty()){
			List<Integer> top = q.remove();
			for(int elem :top) {
				if (!checkedRooms[elem]) {
					q.add(rooms.get(elem));
					checkedRooms[elem] = true;
				}
			}
		}
		for(boolean isReached : checkedRooms) if (!isReached) return false;
		return true;
	}

	static void main() {

	}
}
