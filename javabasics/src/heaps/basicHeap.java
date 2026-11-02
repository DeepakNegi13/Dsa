package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class pair {
	double val;
	int index;

	pair(double val, int index) {
		this.val = val;
		this.index = index;
	}
}

class testScore {
	int k;
	ArrayList<Integer> arr = new ArrayList<>();
	int kthLargest = Integer.MIN_VALUE;
	PriorityQueue<Integer> pq = new PriorityQueue<>();

	public void KthLargest(int k, int[] arr) {
		this.k = k;
		for (int elem : arr) this.arr.add(elem);
		if (arr.length == 0 || k > arr.length) return;
		for (int elem : arr) {
			pq.add(elem);
			if (pq.size() > k) {
				pq.remove();
			}
		}
		this.kthLargest = pq.peek();
	}

	public int add(int val) {
		this.arr.add(val);
		pq.add(val);
		if (pq.size() > k) {
			pq.remove();
		}
		this.kthLargest = pq.peek();
		return kthLargest;
	}
}

public class basicHeap {
	public static int minCost(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) pq.add(arr[i]);
		int totalSum = 0;
		while (pq.size() > 1) {
			int sum = pq.remove() + pq.remove();
			totalSum += sum;
			pq.add(sum);
		}
		return totalSum;
	}

	public int kthSmallest(int[] arr, int k) {
		// Code here
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int elem : arr) {
			pq.add(elem);
			if (pq.size() > k) pq.remove();
		}
		return pq.peek();

	}

	public int findKthLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int elem : arr) {
			pq.add(elem);
			if (pq.size() > k) pq.remove();
		}
		return pq.peek();
	}

	public void nearlySorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0;
		for (int elem : arr) {
			pq.add(elem);
			if (pq.size() > k) {
				arr[i] = pq.remove();
				i++;
			}
		}
		while (i < arr.length) {
			arr[i] = pq.remove();
			i++;
		}
	}

/*	public static double distanceFromOrigin(int x, int y) {
		return Math.sqrt(Math.powExact(x, 2) + Math.powExact(y, 2));
	}

	public int[][] kClosest(int[][] points, int k) {
		double[] distance = new double[points.length];
		for (int i = 0; i < points.length; i++) distance[i] = distanceFromOrigin(points[i][0], points[i][1]);
		PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < distance.length; i++) {
			pq.add(new pair(distance[i], i));
			if (pq.size() > k) pq.remove();
		}
		int[][] ans = new int[k][2];
		int i = 0;
		for (pair elem : pq) {
			ans[i][0] = points[elem.index][0];
			ans[i][1] = points[elem.index][1];
			i++;
		}
		return ans;
	}*/

	public static void main(String[] args) {
		//Min heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(2);
		pq.add(3);
		pq.add(1);
		while (!pq.isEmpty()) System.out.print(pq.remove() + " ");


	}
}
