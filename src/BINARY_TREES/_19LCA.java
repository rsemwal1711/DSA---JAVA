package BINARY_TREES;

public class _19LCA {
    public static Node lca(Node root, Node p, Node q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        Node p = root.left.left;
        Node q = root.left.right.right.right;
        System.out.println(lca(root, p, q).data);
    }
}
