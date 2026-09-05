package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class basicsOfBST {
	//delete the node
	public TreeNode right(TreeNode root) {
		if (root.right.right == null) return root;
		return right(root.right);
	}

	public TreeNode left(TreeNode root) {
		if (root.left.left == null) return root;
		return left(root.left);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			// Zero or one child
			if (root.left == null) return root.right;
			if (root.right == null) return root.left;

			// Two children: replace with inorder successor
			TreeNode successor = root.right;
			while (successor.left != null) {
				successor = successor.left;
			}

			root.val = successor.val;
			root.right = deleteNode(root.right, successor.val);
		}

		return root;
	}

	public static void preOrderTra(TreeNode root, ArrayList<Integer> arr) {
		if (root == null) return;
		arr.add(root.val);
		preOrderTra(root.left, arr);
		preOrderTra(root.right, arr);
	}

	public static void postOrderTra(TreeNode root, ArrayList<Integer> arr) {
		if (root == null) return;
		postOrderTra(root.left, arr);
		postOrderTra(root.right, arr);
		arr.add(root.val);
	}

	//sorted order arraylist
	public static void inOrderTra(TreeNode root, ArrayList<Integer> arr) {
		if (root == null) return;
		inOrderTra(root.left, arr);
		arr.add(root.val);
		inOrderTra(root.right, arr);
	}


	private static void levelOrderTra(TreeNode root, ArrayList<Integer> arr) {
		if (root == null) return;
		Queue q = new LinkedList<TreeNode>();
		q.add(root);
		levelOrderTraHelp(arr, q);


	}

	private static void levelOrderTraHelp(ArrayList<Integer> arr, Queue<TreeNode> q) {
		if (q.isEmpty()) return;
		TreeNode val = q.remove();
		arr.add(val.val);
		if (val.left != null) q.add(val.left);
		if (val.right != null) q.add(val.right);
		levelOrderTraHelp(arr, q);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(9);
		root.right = new TreeNode(7);
		ArrayList arr = new ArrayList<Integer>();
		levelOrderTra(root, arr);
		for (Object i : arr) System.out.print(i + " ");

	}
}
