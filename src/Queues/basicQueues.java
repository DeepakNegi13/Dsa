package Queues;

import stacks.Node;
import basics.integer;

import java.util.*;


class MyQueue {
	Stack<Integer> st = new Stack<>();

	public MyQueue() {
	}

	public void push(int x) {
		st.push(x);
	}

	public int pop() {
		Stack<Integer> st2 = new Stack<>();
		while (st.size() > 1) {
			st2.push(st.pop());
		}
		int n = st.pop();
		while (st2.size() != 0) {
			st.push(st.pop());
		}
		return n;
	}

	public int peek() {
		Stack<Integer> st2 = new Stack<>();
		while (st.size() > 1) {
			st2.push(st.pop());
		}
		int n = st.peek();
		while (st2.size() != 0) {
			st.push(st.pop());
		}
		return n;
	}

	public boolean empty() {
		return st.size() == 0;
	}
}

class QueueLinkedList {
	Node head = null;
	Node temp = null;
	int size = 0;

	public QueueLinkedList() {
	}

	public void add(int elem) {
		size++;
		Node newNode = new Node(elem);
		if (this.head == null) {
			head = newNode;
			temp = newNode;
			return;
		}
		temp.next = newNode;
		temp = newNode;
	}

	public int remove() throws Exception {
		if (size == 0) throw new Exception("QueueUnderFlow");
		this.size--;
		int num = head.data;
		head = head.next;
		return num;
	}

	public int peek() throws Exception {
		if (size == 0) throw new Exception("QueueUnderFlow");
		return head.data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}

public class basicQueues {


	//There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.
	//The rules of the game are as follows:
	//Start at the 1st friend.
	//Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
	//The last friend you counted leaves the circle and loses the game.
	//If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
	//Else, the last friend in the circle wins the game.
	//Given the number of friends, n, and an integer k, return the winner of the game.
	public int findTheWinner(int n, int k) {
		int k2 = 1;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		while (q.size() != 1) {
			if (k2 == k) {
				q.remove();
				k2 = 1;
			} else {
				q.add(q.remove());
				k2++;
			}
		}
		return q.peek();
	}

	public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
		Stack<Integer> st = new Stack<>();
		int size = q.size();
		if (k > size) return q;
		for (int i = 0; i < size; i++) {
			if (i < k) st.push(q.remove());
			else if (i == k) {
				while (st.size() != 0) {
					q.add(st.pop());
				}
				q.add(q.remove());
			} else q.add(q.remove());
		}
		if (k == size) {
			while (st.size() != 0) {
				q.add(st.pop());
			}
		}
		return q;
	}

	public static void add(Queue<Integer> q, int elem, int idx) {
		if (idx == q.size()) {
			q.add(elem);
			return;
		}
		int n = q.size();
		for (int i = 0; i < n; i++) {
			if (i == idx) q.add(elem);
			q.add(q.remove());
		}
	}

	public static void traversingThroughQue(Queue<Integer> qui) {
		int n = qui.size();
		for (int i = 0; i < qui.size(); i++) {
			System.out.print(qui.peek() + " ");
			qui.add(qui.remove());
		}
	}

	public static void remove(Queue<Integer> q, int idx) throws Exception {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			if (i == idx) q.remove();
			else q.add(q.remove());
		}
		if (idx >= q.size()) throw new Exception("indexOutOfBoundError");
	}

	public static int displayElem(Queue<Integer> q, int idx) throws Exception {
		for (int i = 0; i < q.size(); i++) {
			if (i == idx) return q.peek();
			q.add(q.remove());
		}
		if (idx >= q.size()) throw new Exception("indexOutOfBoundError");

		return -1;
	}

	public static void reverse(Queue<Integer> q) {
		if (q.size() == 1) return;
		if (q.size() == 2) {
			q.add(q.remove());
			return;
		}
		int num = q.remove();
		reverse(q);
		q.add(num);
	}

	public int numWaterBottles(int full, int n) {
		int sum = 0;
		int empty = 0;
		while (true) {
			while (full != 0) {
				sum = sum + full;
				empty = empty + full % n;
				full = full / n;
			}
			if (empty < n) break;
			full = empty / n;
			empty = empty - (empty / n) * n;
		}
		return sum;
	}

	public boolean isPalindrome(int x) {
		String st = String.valueOf(x);
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) != st.charAt(st.length() - i - 1)) return false;
		}
		return true;
	}

	public int finalValueAfterOperations(String[] operations) {
		int x = 0;

		for (int i = 0; i < operations.length; i++) {
			if (operations[i].equalsIgnoreCase("X--")) x--;
			else if (operations[i].equalsIgnoreCase("X++")) x++;
			else if (operations[i].equalsIgnoreCase("X--")) x--;
			else if (operations[i].equalsIgnoreCase("X++")) x++;
		}
		return x;
	}

	public void rearrangeQueue(Queue<Integer> q) {
		// code here
		int size = q.size();
		int half = size / 2;
		int[] arr = new int[half];
		for (int i = 0; i < size; i++) {
			if (i < half) {
				arr[i] = q.remove();
			} else {
				q.add(arr[i - half]);
				q.add(q.remove());
			}
		}


	}

	static List<Integer> firstNegInt(int arr[], int k) {
		List<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) q.add(i);
		}
		for (int i = 0; i < arr.length - k + 1; i++) {
			if (q.size() == 0) ans.add(0);
			else if (q.peek() - i < 0) {
				q.remove();
				i--;
			} else if (q.peek() - i < k) {
				ans.add(q.peek());
			}
		}
		return ans;

	}

	public List<String> fizzBuzz(int n) {
		List<String> st = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) st.add("FizzBuzz");
			else if (i % 5 == 0) st.add("Buzz");
			else if (i % 3 == 0) st.add("Fizz");
			else st.add(String.valueOf(i));
		}
		return st;
	}

	public static void main(String[] args) throws Exception {
		
	}
}
