package Graph;
import java.util.ArrayList;
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

	//leetcode 1971
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		if(source==destination) return true;
		List<List<Integer>>  adj = makeAdjList(edges,n);
		boolean[] isVisited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while (!q.isEmpty()){
			source = q.remove();
			for(int elem : adj.get(source)){
				if (!isVisited[elem]){
					isVisited[elem] = true;
					q.add(elem);
				}
			}
		}
		return isVisited[destination];
	}
	private List<List<Integer>>  makeAdjList(int[][] edges,int n) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
		for(int i = 0;i<edges.length;i++){
			int a = edges[i][0]; int b = edges[i][1];
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		return adj;
	}




	static void main() {

	}
}
