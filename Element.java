class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Element {

    // Method to search for a value in the binary tree
    public boolean search(TreeNode root, int key) {
        if (root == null) {
            return false; // Tree is empty or reached leaf node
        }

        if (root.val == key) {
            return true; // Key found
        }

        // Recursively search in left and right subtrees
        return search(root.left, key) || search(root.right, key);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Constructing example binary tree:
        //       10
        //      /  \
        //     20   5
        //    /    /  \
        //   30   15   7

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(30);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int searchKey = 15;
        boolean result = tree.search(root, searchKey);

        System.out.println("Is " + searchKey + " found in the tree? " + result);
    }
}
