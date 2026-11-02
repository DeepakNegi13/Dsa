package ExamPreperation.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {
	public static TreeNode MakeTree(int[] arr) {
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(arr[0]);
		q.add(root);
		int i = 1;
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			if (i < arr.length && arr[i] != -1) {
				temp.left = new TreeNode(arr[i]);
				q.add(temp.left);
			}
			i++;
			if (i < arr.length && arr[i] != -1) {
				temp.right = new TreeNode(arr[i]);
				q.add(temp.right);
			}
			i++;


		}
		return root;
	}

	public static void display(TreeNode root) {
		if (root == null) return;
		display(root.left);
		System.out.print(root.val + " ");

		display(root.right);
	}

	public static void level(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			System.out.print(temp.val + " ");
			if (temp.left != null) q.add(temp.left);
			if (temp.right != null) q.add(temp.right);
		}
	}

	public static void preorder(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode temp = st.pop();
			System.out.print(temp.val + " ");
			if (temp.right != null) st.push(temp.right);
			if (temp.left != null) st.push(temp.left);
		}
	}

	public static void inorder(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		TreeNode node = root;
		while (node != null || (!st.isEmpty())) {
			if (node != null) {
				st.push(node);
				node = node.left;
			} else {
				node = st.pop();
				System.out.print(node.val + " ");
				node = node.right;
			}
		}

	}


	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		TreeNode root = MakeTree(arr);
		inorder(root);
		System.out.println(" ");
		display(root);
	}
}
