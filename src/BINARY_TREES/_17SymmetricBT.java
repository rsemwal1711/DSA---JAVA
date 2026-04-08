package BINARY_TREES;

public class _17SymmetricBT {
    public static boolean isSymmetricUTIL(Node root1, Node root2){
        if(root1 == null || root2 == null) return root1 == root2;
        return (root1.data == root2.data) && isSymmetricUTIL(root1.left, root2.right) && isSymmetricUTIL(root1.right, root2.left);
    }
    public static boolean symmetric(Node root){
        if(root == null) return true;
        return isSymmetricUTIL(root.left, root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.right.right = new Node(4);
        System.out.println(symmetric(root));
    }
}
