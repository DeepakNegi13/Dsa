package stacks;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Implement stack using two Quie
class MyStack {
	Queue<Integer> q = new LinkedList<>();

	public MyStack() {

	}

	public void push(int x) {
		q.add(x);
	}

	public int pop() {
		int n = 0;
		for (int i = 0; i < q.size(); i++) {
			if (i == q.size() - 1) n = q.remove();
			else q.add(q.remove());
		}
		return n;
	}

	public int top() {
		int n = 0;
		for (int i = 0; i < q.size(); i++) {
			if (i == q.size() - 1) n = q.peek();
			q.add(q.remove());
		}
		return n;
	}

	public boolean empty() {
		return q.size() == 0;
	}
}

class ListNodeStack {
	static int size = 0;
	static Node head = null;

	public ListNodeStack() {
	}

	public static void push(int elem) {
		Node newNode = new Node(elem);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public static int peak() throws Exception {
		if (size() == 0) throw new Exception("StackOverflow");
		return head.data;
	}

	public static int pop() throws Exception {
		if (size == 0) throw new Exception("IndexUnderflow");
		size--;
		int ans = head.data;
		head = head.next;
		return ans;
	}

	public static int size() {
		return size;
	}

	public void display() {
		Node temp = head;
		System.out.print("[ ");
		while (temp != null) {
			System.out.print(temp.data + " ");
		}
		System.out.print("]");

	}


}

public class stacksBasics {
	public static void anyPatter(long num) {
		Stack<Integer> st = new Stack<>();
		Stack<Integer> newSt = new Stack<>();
		while (num != 0) {
			st.push((int) (num % 10));
			num = num / 10;
		}
		for (int i = 0; i < 9; i++) {
			while (st.size() != 0) {
				if (st.peek() != 0) {
					System.out.print("* ");
					newSt.push(st.pop() - 1);
				} else {
					System.out.print("  ");
					newSt.push(st.pop());
				}
			}
			while (newSt.size() != 0) {
				st.push(newSt.pop());
			}
			System.out.println();
		}

	}

	public static void printStackInFIFOManner(Stack st) {
		Stack<Integer> newSt = new Stack<>();
		while (st.size() != 0) {
			newSt.push((Integer) st.pop());
		}
		while (newSt.size() != 0) {
			st.push((Integer) newSt.pop());
			System.out.print(st.peek() + " ");
		}
	}

	public static void printStackInFILOManner(Stack st) {
		//time complexity O(2n) space complexity O(n)
		Stack<Integer> newSt = new Stack<>();
		while (st.size() != 0) {
			newSt.push((Integer) st.peek());
			System.out.print(st.pop() + " ");
		}
		while (newSt.size() != 0) {
			st.push((Integer) newSt.pop());
		}
	}

	public static int get(Stack st, int idx) {
		Stack newSt = new Stack<>();
		int size = st.size();
		while (st.size() > idx + 1) {
			newSt.push(st.pop());
		}
		int ans = (int) st.peek();
		while (newSt.size() != 0) {
			st.push(newSt.pop());
		}
		return ans;
	}

	public static void add(Stack st, int val, int idx) {
		Stack<Integer> newSt = new Stack<>();
		while (st.size() > idx) {
			newSt.push((Integer) st.pop());
		}
		st.push(val);
		while (newSt.size() != 0) {
			st.push(newSt.pop());
		}
	}

	public static void reverseStack(Stack st) {
		int[] arr = new int[st.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) st.pop();
		}
		for (int i = 0; i < arr.length; i++) {
			st.push(arr[i]);
		}
	}

	public static void addAtBottomRecursively(Stack<Integer> st, int elem) {
		if (st.size() == 0) {
			st.push(elem);
			return;
		}
		int val = st.pop();
		addAtBottomRecursively(st, elem);
		st.push(val);
	}

	public static void reverseStackRecursively(Stack<Integer> st) {
		if (st.size() == 0) return;
		int elem = st.pop();
		reverseStackRecursively(st);
		addAtBottomRecursively(st, elem);
	}

	public static boolean parenthesisChecker(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (st.size() != 0) {
				if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') st.push(s.charAt(i));
				else if (s.charAt(i) == ')' && st.peek() == '(') st.pop();
				else if (s.charAt(i) == '}' && st.peek() == '{') st.pop();
				else if (s.charAt(i) == ']' && st.peek() == '[') st.pop();
				else return false;

			}
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') st.push(s.charAt(i));
			else return false;
		}
		if (st.size() == 0) return true;
		return false;

	}

	public static int calPoints(String[] operations) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < operations.length; i++) {
			if (operations[i] == "C") {
				st.pop();
			} else if (operations[i] == "D") {
				st.push(st.peek() * 2);
			} else if (operations[i] == "+") {
				int pre = st.pop();
				int ans = pre + st.peek();
				st.push(pre);
				st.push(ans);
			} else {
				st.push(Integer.valueOf(operations[i]));
			}
		}
		int ret = 0;
		while (st.size() != 0) {
			ret += st.pop();
		}
		return ret;
	}

	public static Node removeNodes(Node head) {
		Node temp = head;
		Stack<Node> st = new Stack<>();
		int highest = Integer.MAX_VALUE;
		Node newHead = null;
		while (temp != null) {
			if (temp.data <= highest) {
				if (st.size() == 0) newHead = temp;
				if (st.size() != 0) st.peek().next = temp;
				st.push(temp);
				highest = temp.data;
				temp = temp.next;
				continue;
			}
			if (temp.data > highest) {
				st.pop();
				if (st.size() != 0) highest = st.peek().data;
				else highest = Integer.MAX_VALUE;
				continue;
			}
		}
		return newHead;
	}

	public static ArrayList<Integer> nextLargerElement(int[] arr) {
		int n = arr.length;
		ArrayList<Integer> newAns = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (st.size() == 0) {
				ans[i] = -1;
				st.push(arr[i]);
			} else {
				if (st.peek() > arr[i]) {
					ans[i] = st.peek();
					st.push(st.push(arr[i]));
				} else {
					st.pop();
					i++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			newAns.add(ans[i]);
		}
		return newAns;
	}

	public ArrayList<Integer> calculateSpan(int[] arr) {
		Stack<int[]> st = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (st.size() == 0) {
				st.push(new int[]{arr[i], i});
				ans.add(i);
				continue;
			}
			if (arr[i] >= st.peek()[0]) {
				st.pop();
				i--;

			} else {
				ans.add(i - st.peek()[1]);
				st.push(new int[]{arr[i], i});
			}
		}
		return ans;


	}


	public static void main(String[] args) throws Exception {


	}
}
