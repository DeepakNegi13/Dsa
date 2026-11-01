package ExamPreperation.Tree;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = constructByInorder(arr, 0, arr.length - 1);
		display(root);

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
		TreeNode root = new TreeNode(mid);
		root.left = constructByInorder(arr, st, mid - 1);
		root.right = constructByInorder(arr, mid + 1, end);
		return root;

	}
}
