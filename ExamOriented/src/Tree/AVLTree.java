package Tree;

//optional --> code not ask in exam --> only theory
class AVLTree {

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

    public static void main() {

    }
}
