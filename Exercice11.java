import java.util.Random;

class Node {
    public int value;
    public Node left;
    public Node right;
}

class Tree {

    public Node insert(Node root, int v) {
        if (root == null) {
            root = new Node();
            root.value = v;
        } else if (v < root.value) {
            root.left = insert(root.left, v);
        } else {
            root.right = insert(root.right, v);
        }
        return root;
    }

    public void traverse(Node root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }
}

class BinarySearchTree {
	
    public static void main(String[] args) {
        Node root = null;
        Tree bst = new Tree();
        final int SIZE = 200;
        int[] a = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) { // O(n)
            a[i] = random.nextInt(100);
        }
        for (int i = 0; i < SIZE; i++) { // O (n)
            root = bst.insert(root, a[i]); // O (log(n))
        }
        bst.traverse(root);

    }
    
    
}

/* 
 *la complexité est de O (n(log(n)))
 *
 *
 */
