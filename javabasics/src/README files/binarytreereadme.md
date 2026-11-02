# Binary Trees: a complete guide

A binary tree is a hierarchical structure in which each node has at most two children. Trees model hierarchy and support recursive algorithms naturally. A binary search tree is a special kind of binary tree with an ordering rule; see [binarysearchtreereadme.md](binarysearchtreereadme.md).

## 1. Terms and structure

```text
          A          root
        /   \
       B     C       children of A
      / \     \
     D   E     F     leaves: D, E, F
```

- **Root:** the top node, with no parent.
- **Parent / child:** directly connected nodes, with direction from parent to child.
- **Leaf:** a node with no children.
- **Subtree:** a node together with all its descendants.
- **Depth:** number of edges from the root to a node.
- **Height:** number of edges on the longest downward path from a node to a leaf. Some definitions count nodes instead; state which convention is used.
- **Level:** often depth plus one, though conventions vary.
- **Ancestor / descendant:** a node above / below another along a path.

A binary tree is not automatically sorted or balanced. The left child is not inherently smaller than the right child.

## 2. Java node representation

```java
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}
```

An empty tree is usually represented by `root == null`. A node with one missing child has that reference set to `null`. Two nodes with the same value can still be distinct nodes; references identify nodes, values identify stored data.

## 3. Recursive traversal: depth-first search

Every DFS traversal visits a node and recursively visits its subtrees. The three classic orders differ in when the current node is processed:

```java
void preorder(TreeNode node) {       // node, left, right
    if (node == null) return;
    visit(node);
    preorder(node.left);
    preorder(node.right);
}

void inorder(TreeNode node) {        // left, node, right
    if (node == null) return;
    inorder(node.left);
    visit(node);
    inorder(node.right);
}

void postorder(TreeNode node) {      // left, right, node
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    visit(node);
}
```

All take `O(n)` time for `n` nodes. Recursive call-stack space is `O(h)`, where `h` is tree height: `O(log n)` for a balanced tree and `O(n)` for a completely skewed tree.

- **Preorder** is useful for copying/serializing a tree or processing a parent before children.
- **Inorder** visits sorted order only when the tree is a BST.
- **Postorder** is useful when a parent needs results computed from its children, such as height or subtree totals.

## 4. Level-order traversal: breadth-first search

Use a queue to process nodes level by level:

```java
void levelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        visit(node);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

Time is `O(n)` and queue space is `O(w)`, where `w` is maximum tree width (up to `O(n)`). To process one level at a time, capture `int levelSize = queue.size()` before processing that level.

## 5. Common tree computations

### Count nodes and sum values

Recursively combine the current node with the counts or sums of the left and right subtrees. Define an empty subtree's count and sum as zero.

### Height / maximum depth

With height measured in nodes, define an empty tree's height as `0` and a nonempty node's height as `1 + max(height(left), height(right))`. With edge height, use empty height `-1`. Both conventions work if used consistently.

### Diameter

The diameter is the longest path between any two nodes. A longest path through a node uses its left and right subtree heights. The global answer may pass through a node other than the root. A common `O(n)` approach computes height and updates the best diameter in the same postorder traversal; recomputing each subtree height independently can make the algorithm `O(n^2)` on a skewed tree.

### Root-to-leaf paths

Carry the path during DFS, or return information from children. A leaf is a node with both children `null`. Be clear whether paths are returned, summed, or checked against a target.

### Balanced-tree check

A tree is height-balanced when each node's left and right subtree heights differ by at most one. Compute heights bottom-up and propagate a failure sentinel (such as `-1`) to avoid repeated height calculations.

## 6. Recursion versus iteration

Recursive solutions match the tree structure and are often easiest to reason about. For very deep trees, recursion can overflow the Java call stack. Use an explicit `Deque` for iterative preorder/inorder/postorder traversal or a queue for level order. An unbalanced tree can have height `n`, even when the input is called a binary tree.

## 7. Building trees from traversals

Some traversal pairs uniquely identify a tree when values are distinct:

- Preorder + inorder: preorder reveals each subtree root; inorder partitions its left and right subtrees.
- Postorder + inorder: postorder's last item is the root; inorder partitions its subtrees.

An index map for inorder positions avoids repeatedly searching the array and gives `O(n)` construction. Duplicate values make the split ambiguous unless more information is provided. Preorder and postorder alone generally do not uniquely determine an arbitrary binary tree.

## 8. Binary tree shapes

- **Full/proper:** every node has either zero or two children.
- **Complete:** every level is full except possibly the last, which is filled left to right.
- **Perfect:** every internal node has two children and all leaves are at the same depth.
- **Balanced:** height is controlled relative to the number of nodes, according to a specified rule.
- **Skewed:** each node has at most one child, resembling a linked list.

These definitions are distinct. For example, a complete tree need not be perfect.

## 9. Common pitfalls

- Forgetting the `null` base case.
- Calling a missing child as if it had a value.
- Confusing depth (from root down) and height (from a node down).
- Assuming the root must be on a longest path or that a diameter must pass through it.
- Using inorder as sorted traversal for a tree that is not a BST.
- Recomputing subtree facts repeatedly and creating `O(n^2)` work.
- Treating equal values as the same node.
- Ignoring skewed-tree recursion depth.
- Processing all queue contents as one level without saving the level size.

## 10. A tree-problem workflow

1. Define the result for an empty tree.
2. Ask whether the parent needs information from children (postorder), must be processed before them (preorder), or requires level order.
3. Decide what a recursive call returns and what it updates globally.
4. State the subtree invariant in one sentence.
5. Test empty, single-node, left-skewed, right-skewed, and balanced examples.
6. Analyze time by counting visits and space by tree height or queue width.

## 11. Practice progression

Implement preorder/inorder/postorder; level-order traversal; maximum depth; same tree; invert tree; balanced-tree check; diameter; path sum; lowest common ancestor; serialize/deserialize; build from traversals; and zigzag level order. Draw small trees and trace the return value from each subtree.
