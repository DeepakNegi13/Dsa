package stacks;

import java.util.Stack;

public class anyPattern {
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

	public static void main(String[] args) {

	}
}