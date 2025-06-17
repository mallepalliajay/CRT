class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeSum {
    Node root;
    int sumOfNodes(Node node) {
        if (node == null)
            return 0;
        return node.val + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeSum tree = new BinaryTreeSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int totalSum = tree.sumOfNodes(tree.root);
        System.out.println("Sum of all nodes in the binary tree: " + totalSum); 
    }
}
