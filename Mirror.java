class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Mirror {

  
    public boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true; 
        }

        
        return search(root.left, key) || search(root.right, key);
    }

    // Mirror the tree - swaps left and right children of every node recursively
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        // swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recursively mirror left and right subtrees
        mirror(root.left);
        mirror(root.right);
    }

    // Utility method to do inorder traversal (to see the tree structure)
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Construct example tree:
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

        // Search for a value
        int key = 15;
        boolean found = tree.search(root, key);
        System.out.println("Is " + key + " found? " + found);

        // Show inorder before mirroring
        System.out.print("Inorder before mirror: ");
        tree.inorderTraversal(root);
        System.out.println();

        // Mirror the tree
        tree.mirror(root);

        // Show inorder after mirroring
        System.out.print("Inorder after mirror: ");
        tree.inorderTraversal(root);
        System.out.println();
    }
}
