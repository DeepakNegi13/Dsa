package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

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


	public static void main(String[] args) {
		//Min heap


	}
}
