package BINARY_TREES;

public class _11SameTreeOrNot {
    public static boolean sameTreeOrNot(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) return false;
        return sameTreeOrNot(root1.left, root2.left) && sameTreeOrNot(root1.right, root2.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.left.right.right = new Node(6);
        root1.left.right.right.right = new Node(7);
        System.out.println(sameTreeOrNot(root, root1));
    }
}
