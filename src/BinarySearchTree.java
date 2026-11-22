
public class BinarySearchTree {

    // Represents one node in the tree
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // insert a number into the tree
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insert(current.left, value);
        } else if (value > current.value) {
            current.right = insert(current.right, value);
        }
        return current;
    }

    // Find a number and count how many nodes were visited
    public int find(int value) {
        return find(root, value);
    }

    private int find(Node current, int value) {
        int nodesVisited = 0;

        while (current != null) {
            nodesVisited++;
            if (value == current.value) {
                return nodesVisited;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return nodesVisited;
    }

    // Calculate the height of the tree
    public int height() {
        return height(root);
    }

    private int height(Node current) {

        if (current == null) {
            return 0;
        }

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
