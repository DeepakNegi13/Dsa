# Binary Search Trees (BSTs): a complete guide

A binary search tree is a binary tree organized by a key-ordering invariant. This invariant makes search, insertion, and deletion efficient when the tree stays reasonably balanced.

## 1. The BST ordering invariant

For a node with key `x`, every key in its left subtree must be less than `x`, and every key in its right subtree must be greater than `x`—if the chosen policy disallows duplicates. The rule applies to entire subtrees, not just immediate children:

```text
          8
        /   \
       3     12
      / \    / \
     1   6  10  14
```

Every value below node `8` on its left must be less than `8`; every value in its right subtree must be greater than `8`. Merely checking each node against its direct parent is insufficient.

Duplicate-key policy must be explicit. Common choices are: reject duplicates; store a count in the node; or consistently place equal keys on one side. Validation bounds and insertion/deletion must use the same policy.

## 2. Search

At each node, compare the target with the node key. If equal, it is found. If smaller, only the left subtree can contain it; if larger, only the right subtree can contain it.

```java
static TreeNode search(TreeNode root, int target) {
    TreeNode current = root;
    while (current != null) {
        if (target == current.value) return current;
        current = target < current.value ? current.left : current.right;
    }
    return null;
}
```

Search takes `O(h)`, where `h` is tree height. If balanced, `h = O(log n)`; if skewed, `h = O(n)`.

## 3. Insertion

Follow the search path until reaching a missing child, then attach the new node there. The ordering rule remains true because every earlier comparison constrained the valid range. Decide what happens for equal keys.

Recursive insertion often returns the updated subtree root:

```java
static TreeNode insert(TreeNode node, int value) {
    if (node == null) return new TreeNode(value);
    if (value < node.value) node.left = insert(node.left, value);
    else if (value > node.value) node.right = insert(node.right, value);
    // Here equal values are ignored; choose another policy if needed.
    return node;
}
```

Returning the node matters when insertion changes the root of the subtree, especially when the original tree is empty or when balancing rotations are used.

## 4. Deletion: three cases

First find the node and its parent or recurse to it. Then handle:

1. **Leaf:** remove it by setting the parent's corresponding child to `null`.
2. **One child:** replace it with its only child.
3. **Two children:** replace its key with its inorder successor (smallest key in the right subtree) or predecessor (largest in the left subtree), then delete that successor/predecessor from its original location.

The successor has no left child, so its deletion reduces to the leaf or one-child case. Ensure the root can be replaced; a recursive method that returns the new subtree root handles this cleanly.

Do not copy only a key if a node holds associated data that must move with it. In production maps/sets, use established library implementations unless implementing the structure is the goal.

## 5. Minimum, maximum, predecessor, and successor

- Minimum: repeatedly follow `left` until there is no left child.
- Maximum: repeatedly follow `right` until there is no right child.
- Successor: if a right subtree exists, its minimum is the successor. Otherwise, walk ancestors until finding one for which the node lies in its left subtree.
- Predecessor: symmetric to successor.

If nodes do not store parent references, an ancestor search may need to begin at the root.

## 6. Traversal and sorted order

Inorder traversal (`left, node, right`) visits BST keys in ascending order. It can be used to produce sorted values or verify ordering, but collecting all values costs `O(n)` time and space for the output. An iterator can use an explicit stack with `O(h)` auxiliary space.

## 7. Validating a BST correctly

Checking only `node.left.value < node.value < node.right.value` is not enough. Pass an allowed range down the tree. Each left descent tightens the upper bound; each right descent tightens the lower bound.

```text
validate(node, low, high):
    if node is empty: valid
    if node.key is outside the allowed range: invalid
    validate(left, low, node.key)
    validate(right, node.key, high)
```

For integer keys, avoid artificial `Integer.MIN_VALUE - 1` and `Integer.MAX_VALUE + 1` bounds, which overflow. Use nullable bounds, a wider type, or explicit “bound exists” flags. Adjust strictness for the chosen duplicate policy.

## 8. Height and balancing

Ordinary BST operations depend on height. Inserting sorted data into an unbalanced BST can create a chain:

```text
1 -> right 2 -> right 3 -> right 4 -> ...
```

Then search, insert, and delete are `O(n)`, not `O(log n)`. Self-balancing trees restore logarithmic height after updates. AVL trees maintain a tight height balance; red-black trees use color rules to guarantee logarithmic height with less rigid balance. Java's `TreeMap` and `TreeSet` provide ordered maps/sets using a balanced-tree implementation.

## 9. BST versus binary search on an array

Both use order to eliminate possibilities, but their storage differs. A sorted array offers `O(log n)` search and `O(1)` indexed access, but insertion/removal shifts values (`O(n)`). A balanced BST offers `O(log n)` search and update by following links, and supports ordered navigation. An unbalanced BST can lose this advantage.

## 10. Common mistakes

- Checking only direct parent-child comparisons instead of the whole allowed range.
- Forgetting to return an updated subtree root.
- Not handling deletion of the root.
- Using inconsistent duplicate rules.
- Assuming an ordinary BST is balanced.
- Confusing node identity with key equality.
- Overlooking integer overflow in validation bounds.
- Using recursive code on an extremely skewed tree and overflowing the call stack.

## 11. Practice progression

Search and insert; find minimum/maximum; validate a BST; kth smallest element; lowest common ancestor in a BST; delete a node; convert a sorted array to a balanced BST; find a pair with target sum; and recover a BST with swapped keys. For each operation, draw the search path and verify the invariant after changing links.
