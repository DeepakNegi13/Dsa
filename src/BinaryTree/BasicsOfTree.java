package BinaryTree;


import javax.swing.tree.TreeNode;
import java.util.*;

class pair {
	BinaryNodes node;
	int level;

	public pair(BinaryNodes node, int level) {
		this.node = node;
		this.level = level;
	}
}

class BinaryNodes {
	int val;
	public BinaryNodes left;
	public BinaryNodes right;

	public BinaryNodes(int val) {
		this.val = val;
	}
}

public class BasicsOfTree {
	//print nth level of binaryTree
	//level start from zero just like index
	public static void nthLevelHelper(BinaryNodes root, int level, int currentLevel) {
		if (root == null) return;
		if (currentLevel == level) System.out.print(root.val + " ");
		nthLevelHelper(root.left, level, currentLevel + 1);
		nthLevelHelper(root.right, level, currentLevel + 1);
	}
	public static void nthLevel(BinaryNodes root, int level) {
		nthLevelHelper(root, level, 0);
	}

	//arrange according to level
	public List<List<Integer>> levelOrder(BinaryNodes root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<pair> q = new LinkedList<>();
		int currentLevel = 0;
		q.add(new pair(root, currentLevel));
		while (!q.isEmpty()) {
			pair temp = q.remove();
			if (ans.size() == temp.level) {
				ans.add(new ArrayList<>());
				ans.get(ans.size() - 1).add(temp.node.val);

			} else ans.get(ans.size() - 1).add(temp.node.val);
			currentLevel = temp.level + 1;
			if (temp.node.left != null) q.add(new pair(temp.node.left, currentLevel));
			if (temp.node.right != null) q.add(new pair(temp.node.right, currentLevel));
		}
		return ans;
	}

	//level order printing2
	public static void levelOrderTraversal2(BinaryNodes root) {
		for (int i = 0; i < levelsOfBinaryTree(root); i++) {
			nthLevel(root, i);
			System.out.println();
		}
	}

	//level order printing
	public static void levelOrderTraversal(BinaryNodes root) {
		Queue<BinaryNodes> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryNodes front = q.remove();
			System.out.print(front.val + " ");
			if (front.left != null) q.add(front.left);
			if (front.right != null) q.add(front.right);
		}
	}

	//levels of binary tree
	public static int levelsOfBinaryTree(BinaryNodes root) {
		return (root == null) ? 0 : (1 + Math.max(levelsOfBinaryTree(root.left), levelsOfBinaryTree(root.right)));
	}

	//max elem of binary tree
	public static int maxElemOfBinaryTree(BinaryNodes root) {
		return (root == null) ? Integer.MIN_VALUE : Math.max(root.val, Math.max(maxElemOfBinaryTree(root.left), maxElemOfBinaryTree(root.right)));
	}

	//product of all element
	public static int productOfElemOfBinaryTree(BinaryNodes root) {
		return (root == null) ? 1 : (root.val * productOfElemOfBinaryTree(root.left) * productOfElemOfBinaryTree(root.right));
	}

	//sum of all element
	public static int sumOfElemOfBinaryTree(BinaryNodes root) {
		return (root == null) ? 0 : (root.val + sumOfElemOfBinaryTree(root.left) + sumOfElemOfBinaryTree(root.right));
	}

	// size of binary tree
	public static int sizeOfTree(BinaryNodes root) {
		return (root == null) ? 0 : (1 + sizeOfTree(root.left) + sizeOfTree(root.left));
	}

	//traversing in binary tree
	public void traverse(List<Integer> li, BinaryNodes root) {
		if (root == null) return;
		li.add(root.val);
		traverse(li, root.left);
		traverse(li, root.right);

	}

	//preorder traversal
	public List<Integer> preorderTraversal(BinaryNodes root) {
		List<Integer> li = new ArrayList<>();
		traverse(li, root);
		return li;
	}

	//traversal to binary tree
	public static void traversalToBinaryTree(BinaryNodes root) {
		if (root == null) return;
		System.out.print(root.val + " ");
		traversalToBinaryTree(root.left);
		traversalToBinaryTree(root.right);
	}


	public static void main(String[] args) {
		BinaryNodes a = new BinaryNodes(1);
		BinaryNodes b = new BinaryNodes(2);
		BinaryNodes c = new BinaryNodes(3);
		BinaryNodes d = new BinaryNodes(4);
		BinaryNodes e = new BinaryNodes(5);
		BinaryNodes f = new BinaryNodes(6);
		BinaryNodes g = new BinaryNodes(7);
		BinaryNodes h = new BinaryNodes(8);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		g.right = h;
		levelOrderTraversal2(a);
	}
}
