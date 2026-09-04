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
	public void right(TreeNode root, TreeNode secLeaf) {
		if (root.right.right == null) {
			secLeaf = root;
			return;
		}
		right(root.right, secLeaf);
	}

	public void left(TreeNode root, TreeNode secLeaf) {
		if (root.left.left == null) {
			secLeaf = root;
			return;
		}
		left(root.left, secLeaf);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return root;
		if (root.val == key) return null;
		if (root.val > key) {
			if (root.left == null) return root;
			if (root.left.val == key) {
				if (root.left.left == null && root.left.right == null) {
					root.left = null;
					return root;
				} else if (root.left.left == null && root.left.right != null) {
					root.left = root.left.right;
					return root;
				} else if (root.left.left != null && root.left.right == null) {
					root.left = root.left.left;
					return root;
				} else {
					TreeNode secLeaf = null;
					right(root.left, secLeaf);
					root.left.val = secLeaf.right.val;
					if (secLeaf.right.left != null) secLeaf.right = secLeaf.right.left;
					else secLeaf.right = null;
				}
			}
			deleteNode(root.left, key);
		} else {
			if (root.right == null) return root;
			if (root.right.val == key) {
				if (root.right.left == null && root.right.right == null) {
					root.right = null;
					return root;
				} else if (root.right.left == null && root.right.right != null) {
					root.right = root.right.right;
					return root;
				} else if (root.right.left != null && root.right.right == null) {
					root.right = root.right.left;
					return root;
				} else {
					TreeNode secLeaf = null;
					left(root.right, secLeaf);
					root.right.val = secLeaf.left.val;
					if (secLeaf.left.right != null) secLeaf.left = secLeaf.left.right;
					else secLeaf.left = null;
				}
			}
			deleteNode(root.left, key);
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
