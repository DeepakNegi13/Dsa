package BinaryTree;


import java.util.ArrayList;
import java.util.List;

class BinaryNodes {
	int val;
	public BinaryNodes left;
	public BinaryNodes right;

	public BinaryNodes(int val) {
		this.val = val;
	}
}

public class BasicsOfTree {
	public static int levelsOfBinaryTree(BinaryNodes root) {
		return (root == null) ? 0 : (1 + Math.max(levelsOfBinaryTree(root.left), levelsOfBinaryTree(root.right)));
	}

	public static int maxElemOfBinaryTree(BinaryNodes root) {
		return (root == null) ? Integer.MIN_VALUE : Math.max(root.val, Math.max(maxElemOfBinaryTree(root.left), maxElemOfBinaryTree(root.right)));
	}

	public static int productOfElemOfBinaryTree(BinaryNodes root) {
		return (root == null) ? 1 : (root.val * productOfElemOfBinaryTree(root.left) * productOfElemOfBinaryTree(root.right));
	}

	public static int sumOfElemOfBinaryTree(BinaryNodes root) {
		return (root == null) ? 0 : (root.val + sumOfElemOfBinaryTree(root.left) + sumOfElemOfBinaryTree(root.right));
	}

	public static int sizeOfTree(BinaryNodes root) {
		return (root == null) ? 0 : (1 + sizeOfTree(root.left) + sizeOfTree(root.left));
	}

	public void traverse(List<Integer> li,BinaryNodes root){
		if(root==null) return;
		li.add(root.val);
		traverse(li,root.left);
		traverse(li,root.right);

	}
	public List<Integer> preorderTraversal(BinaryNodes root) {
		List<Integer> li = new ArrayList<>();
		traverse(li,root);
		return li;
	}

	public static void traversalToBinaryTree(BinaryNodes root) {
		if (root == null) return;
		System.out.print(root.val + " ");
		traversalToBinaryTree(root.left);
		traversalToBinaryTree(root.right);
	}

	public static void main(String[] args) {
		BinaryNodes a = new BinaryNodes(1);
		BinaryNodes b = new BinaryNodes(9);
		BinaryNodes c = new BinaryNodes(8);
		BinaryNodes d = new BinaryNodes(4);
		BinaryNodes e = new BinaryNodes(5);
		BinaryNodes f = new BinaryNodes(6);
		BinaryNodes g = new BinaryNodes(7);
		BinaryNodes h = new BinaryNodes(9);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		g.right = h;
		traversalToBinaryTree(a);
		System.out.println();
		System.out.println(maxElemOfBinaryTree(a));
		System.out.println(levelsOfBinaryTree(a));
	}
}
