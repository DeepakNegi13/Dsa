package ExamPreperation.Tree;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	public static TreeNode delete(TreeNode root, int n) {
		if (root == null) return root;
		if (root.val > n) {
			root.left = delete(root.left, n);

		} else if (root.val < n) root.right = delete(root.right, n);
		else {
			//if one or zero child present
			if (root.left == null) return root.right;
			if (root.right == null) return root.left;

			//two child present
			// their is no left child in the successor
			TreeNode succesor = root.right;
			if (succesor.left == null) {
				root.val = succesor.val;
				root.right = succesor.right;
			}
			while (succesor.left.left != null) succesor = succesor.left;
			root.val = succesor.left.val;
			succesor.left = null;
		}
		return root;
	}


	public static boolean search(TreeNode root, int n) {
		if (root == null) return false;
		if (root.val > n) return search(root.left, n);
		if (root.val < n) return search(root.right, n);
		return true;
	}

	public static void insert(TreeNode root, int n) {
		if (root == null) return;
		if (root.val > n) {
			if (root.left == null) root.left = new TreeNode(n);
			else insert(root.left, n);
		} else {
			if (root.right == null) root.right = new TreeNode(n);
			else insert(root.right, n);
		}

	}

	public static TreeNode constructBylevelOrder(int[] arr) {
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

	public static TreeNode constructByInorder(int[] arr, int st, int end) {
		if (st > end) return null;
		int mid = (st + end) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = constructByInorder(arr, st, mid - 1);
		root.right = constructByInorder(arr, mid + 1, end);
		return root;

	}

	static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = constructByInorder(arr, 0, arr.length - 1);
		display(root);
		System.out.println();
		delete(root, 6);
		display(root);

	}
}
