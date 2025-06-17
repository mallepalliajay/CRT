class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
        left = right = null;
    }
}
public class BinaryTreeTraversal {
    Node root;
    void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);  

        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(tree.root);  
    }
}
