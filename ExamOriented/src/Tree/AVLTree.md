# Masterclass Notes: AVL Trees

**Author:** Senior Computer Science Educator (15+ Years Experience)

**Topic:** Self-Balancing Binary Search Trees (Adelson-Velsky & Landis)

## 1. What is an AVL Tree?

An **AVL Tree** (named after Soviet inventors Georgy Adelson-Velsky and Evgenii Landis in 1962) is a **strictly self-balancing Binary Search Tree (BST)**.

### The Problem It Solves

In a standard Binary Search Tree, operations like search, insertion, and deletion run in $\mathcal{O}(h)$ time, where $h$ is tree height.

* If keys arrive in sorted or reverse-sorted order (e.g., $10 \to 20 \to 30 \to 40$), the BST degrades into a **skewed linked list**.

* In a skewed BST: $h = \mathcal{O}(n)$, causing worst-case lookup, insert, and delete times to degrade to $\mathcal{O}(n)$.

An AVL tree enforces a geometric height invariant that guarantees:

$$
h \le 1.44 \log_2(n + 2)
$$


This guarantees search, insertion, and deletion operations run in **strict** $\mathcal{O}(\log n)$ **time**.

## 2. Formation Conditions & Properties

For a binary tree to be a valid AVL tree, it must satisfy two fundamental invariants:

1. **Standard BST Invariant:**

   * For every node $X$, all keys in the left subtree are strictly less than $X.\text{key}$.

   * All keys in the right subtree are strictly greater than $X.\text{key}$.

   * Duplicate keys are typically disallowed or tracked via node frequency counters.

2. **AVL Balance Invariant:**

   * For every node $X$, the absolute difference between the height of its left subtree and the height of its right subtree cannot exceed $1$:
     

     $$
     \vert{}h_{\text{left}} - h_{\text{right}}\vert{} \le 1
     $$

### Height Definition

* Height of an empty subtree (null node): $-1$ (or $0$, depending on convention; standard algorithmic literature uses $-1$ for $\text{null}$ and $0$ for a leaf).

* Height of node $X$:
  

  $$
  \text{height}(X) = 1 + \max(\text{height}(X.\text{left}), \text{height}(X.\text{right}))
  $$

### Balance Factor ($BF$)

$$
\text{Balance Factor}(X) = \text{height}(X.\text{left}) - \text{height}(X.\text{right})
$$


*(Note: Some texts define it as* $\text{right} - \text{left}$*. Here, we use* $\text{left} - \text{right}$*.)*

* **Balanced:** $BF \in \{-1, 0, 1\}$

* **Left-Heavy:** $BF > 1$ ($+2$)

* **Right-Heavy:** $BF < -1$ ($-2$)

## 3. The 4 Fundamental Rotations

Rotations are local constant-time ($\mathcal{O}(1)$) pointer adjustments that restore height balance without violating BST ordering.

```
       Rotate Right (Clockwise)
         Y                   X
        / \                 / \
       X   C    <=====>    A   Y
      / \                     / \
     A   B                   B   C
       Rotate Left (Counter-Clockwise)

```

### 1. Left-Left (LL) Condition $\to$ Right Rotation

* **Trigger:** An insertion occurred into the **left** subtree of the **left** child of an imbalanced node ($BF = +2$, child $BF \ge 0$).

* **Correction:** Single **Right Rotation** around the unbalanced node.

```
       Z (BF = +2)                   Y (BF = 0)
      /                             /   \
     Y (BF = +1)     =====>        X     Z
    /
   X

```

### 2. Right-Right (RR) Condition $\to$ Left Rotation

* **Trigger:** An insertion occurred into the **right** subtree of the **right** child of an imbalanced node ($BF = -2$, child $BF \le 0$).

* **Correction:** Single **Left Rotation** around the unbalanced node.

```
   Z (BF = -2)                       Y (BF = 0)
    \                               /   \
     Y (BF = -1)     =====>        Z     X
      \
       X

```

### 3. Left-Right (LR) Condition $\to$ Left-Right Double Rotation

* **Trigger:** An insertion occurred into the **right** subtree of the **left** child ($BF = +2$, child $BF = -1$).

* **Correction:**

  1. Perform a **Left Rotation** on the left child.

  2. Perform a **Right Rotation** on the original imbalanced node.

```
      Z (+2)                Z (+2)
     /                     /                     Y (0)
    X (-1)    =====>      Y (+1)    =====>      /   \
     \                   /                     X     Z
      Y                 X

```

### 4. Right-Left (RL) Condition $\to$ Right-Left Double Rotation

* **Trigger:** An insertion occurred into the **left** subtree of the **right** child ($BF = -2$, child $BF = +1$).

* **Correction:**

  1. Perform a **Right Rotation** on the right child.

  2. Perform a **Left Rotation** on the original imbalanced node.

```
   Z (-2)                 Z (-2)
    \                      \                     Y (0)
     X (+1)   =====>        Y (-1)    =====>    /   \
    /                        \                 Z     X
   Y                          X

```

## 4. Insertion Walkthrough & Algorithm

Insertion proceeds in two phases:

1. **Standard recursive BST insertion** to place the new key at a leaf position ($\mathcal{O}(\log n)$ down-traversal).

2. **Backtracking (bottom-up unwinding)**:

   * Recalculate heights.

   * Compute Balance Factor.

   * If $\vert{}BF\vert{} > 1$, apply the appropriate rotation.

   * **Crucial Rule:** During insertion, **at most one single or double rotation** is needed to rebalance the entire tree. Once restored, the height of that subtree returns to its pre-insertion height, leaving all higher ancestors balanced.

### Summary of Rebalance Cases on Node `curr`

* If `BF > 1`:

  * If `key < curr.left.key` $\to$ **Right Rotate(curr)** (LL)

  * If `key > curr.left.key` $\to$ **Left Rotate(curr.left)** then **Right Rotate(curr)** (LR)

* If `BF < -1`:

  * If `key > curr.right.key` $\to$ **Left Rotate(curr)** (RR)

  * If `key < curr.right.key` $\to$ **Right Rotate(curr.right)** then **Left Rotate(curr)** (RL)

## 5. Deletion Walkthrough & Algorithm

Deletion is structurally more demanding than insertion:

1. **Standard BST Deletion:**

   * **Node is a leaf:** Remove it.

   * **Node has one child:** Replace the node with its child.

   * **Node has two children:** Find the in-order successor (smallest in right subtree) or in-order predecessor, swap the value, and delete that successor/predecessor recursively.

2. **Bottom-Up Backtracking:**

   * Update height and compute $BF$.

   * **Propagation:** Unlike insertion, rebalancing an imbalanced ancestor after deletion can decrease its height, which may induce an imbalance at higher levels. Rebalancing may trigger up to $\mathcal{O}(\log n)$ rotations all the way to the root.

### Balance Factor Scenarios During Deletion Rebalance

When checking an imbalanced ancestor `node`:

* **Case 1: `BF(node) == +2`**

  * If `BF(node.left) >= 0` $\to$ **Right Rotate(node)** *(Note the `>= 0`; equality handles the case where subtrees are of equal height).*

  * If `BF(node.left) < 0` $\to$ **Left Rotate(node.left)**, then **Right Rotate(node)**.

* **Case 2: `BF(node) == -2`**

  * If `BF(node.right) <= 0` $\to$ **Left Rotate(node)**.

  * If `BF(node.right) > 0` $\to$ **Right Rotate(node.right)**, then **Left Rotate(node)**.

## 6. End-to-End Implementation

```
class Node {
    int key;
    int height;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        this.height = 1; // Leaf nodes start with height 1
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    public int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    public int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Right Rotation (Clockwise)
    public Node rotateRight(Node z) {
        Node y = z.left;
        Node T3 = y.right;

        // Perform rotation
        y.right = z;
        z.left = T3;

        // Update heights (z first, then y)
        z.height = 1 + Math.max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    // Left Rotation (Counter-clockwise)
    public Node rotateLeft(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = z;
        z.right = T2;

        // Update heights (z first, then y)
        z.height = 1 + Math.max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    // Insert key into subtree rooted at node
    public Node insert(Node root, int key) {
        // 1. Standard BST insertion
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicate keys not allowed
        }

        // 2. Update height of current ancestor node
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // 3. Get balance factor
        int balance = getBalance(root);

        // 4. Resolve imbalances
        // Left-Left (LL) Case
        if (balance > 1 && key < root.left.key) {
            return rotateRight(root);
        }

        // Right-Right (RR) Case
        if (balance < -1 && key > root.right.key) {
            return rotateLeft(root);
        }

        // Left-Right (LR) Case
        if (balance > 1 && key > root.left.key) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Right-Left (RL) Case
        if (balance < -1 && key < root.right.key) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    private Node getMinValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Delete key from subtree rooted at node
    public Node delete(Node root, int key) {
        // 1. Standard BST delete
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: get inorder successor (smallest in right subtree)
            Node temp = getMinValueNode(root.right);
            root.key = temp.key;
            root.right = delete(root.right, temp.key);
        }

        // If tree had only one node
        if (root == null) {
            return null;
        }

        // 2. Update height
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // 3. Get balance factor
        int balance = getBalance(root);

        // 4. Resolve imbalances
        // Left-Left (LL) Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rotateRight(root);
        }

        // Left-Right (LR) Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Right-Right (RR) Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return rotateLeft(root);
        }

        // Right-Left (RL) Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }
}

```

## 7. Advanced Theory & Architectural Insights

### Proof of Logarithmic Height (Fibonacci Bounds)

What is the minimum number of nodes $N(h)$ required to construct an AVL tree of height $h$?

* $N(0) = 1$

* $N(1) = 2$

* To minimize nodes for height $h$, one child must have height $h-1$ and the other height $h-2$:
  

  $$
  N(h) = 1 + N(h-1) + N(h-2)
  $$

This recurrence mirrors the **Fibonacci sequence**:

$$
N(h) = F_{h+3} - 1
$$


Using the golden ratio $\phi = \frac{1 + \sqrt{5}}{2} \approx 1.618$:

$$
N(h) \approx \frac{\phi^{h+3}}{\sqrt{5}} - 1 \implies h \approx 1.44 \log_2(N)
$$


Thus, height is strictly bounded by $\mathcal{O}(\log N)$ in the absolute worst case.

### Comparison: AVL Tree vs. Red-Black Tree

| Feature | AVL Tree | Red-Black Tree | 
| ----- | ----- | ----- | 
| **Balance Strictness** | Strict ($\vert{}h_L - h_R\vert{} \le 1$) | Relaxed (longest path $\le 2 \times$ shortest path) | 
| **Max Height Bound** | $\approx 1.44 \log_2 n$ | $\approx 2.00 \log_2 n$ | 
| **Search Performance** | **Faster** (flatter tree profile) | Slower (higher constant factor) | 
| **Insertion Rotations** | At most $1$ single/double rotation | At most $2$ rotations | 
| **Deletion Rotations** | Up to $\mathcal{O}(\log n)$ rotations | At most $3$ rotations | 
| **Metadata Per Node** | Height or 2-bit balance factor | 1-bit color (`RED`/`BLACK`) | 
| **Production Use Cases** | Read-heavy databases, lookup dictionaries | Write-intensive workloads (`std::map`, Linux CFS) | 

## 8. Summary Checklist for Exams & Interviews

1. **Balance check:** Always compute $BF = \text{height}(\text{left}) - \text{height}(\text{right})$.

2. **Signs determine rotation type:**

   * Positive $BF$ ($+2$) with child positive/zero $BF$ $\to$ **LL (Rotate Right)**

   * Positive $BF$ ($+2$) with child negative $BF$ $\to$ **LR (Rotate Left-Right)**

   * Negative $BF$ ($-2$) with child negative/zero $BF$ $\to$ **RR (Rotate Left)**

   * Negative $BF$ ($-2$) with child positive $BF$ $\to$ **RL (Rotate Right-Left)**

3. **Worst-case complexities:**

   * Space: $\mathcal{O}(n)$

   * Search: $\mathcal{O}(\log n)$

   * Insertion: $\mathcal{O}(\log n)$ time ($\mathcal{O}(1)$ rotations)

   * Deletion: $\mathcal{O}(\log n)$ time ($\mathcal{O}(\log n)$ rotations)