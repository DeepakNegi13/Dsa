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
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(9);
		root.right = new TreeNode(7);
		ArrayList arr = new ArrayList<Integer>();
		levelOrderTra(root, arr);
		for (Object i : arr) System.out.print(i + " ");

	}

	//delete node having zero child
	public static TreeNode deleteZeroChild(TreeNode root, int k) {
		if (root.val == k) {
			root = null;
			return root;
		}
		if (root.val > k) {
			if (root.left == null) return root;
			if (root.left.val == k) {
				root.left = null;
			} else deleteZeroChild(root.left, k);
		} else {
			if (root.right == null) return root;
			if (root.right.val == k) {
				root.right = null;
			} else deleteZeroChild(root.right, k);
		}
		return root;
	}

	//delete node having one child
	public static TreeNode deleteOneChild(TreeNode root, int k) {
		if (root == null) return root;
		if (root.val == k) {
			root = null;
			return root;
		}
		if (root.val > k) {
			if (root.left == null) return root;
			if (root.left.val == k) {
				if (root.left.right == null) root.left = root.left.left;
				else root.left = root.left.right;
			} else deleteZeroChild(root.left, k);
		} else {
			if (root.left == null) return root;
			if (root.right.val == k) {
				if (root.right.right == null) root.right = root.right.left;
				else root.right = root.right.right;
			} else deleteZeroChild(root.right, k);
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
}
