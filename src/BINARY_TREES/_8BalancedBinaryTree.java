package BINARY_TREES;

public class _8BalancedBinaryTree {
    public static int getHeight(Node root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }
    public static boolean isBalanced(Node root){
        if(root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

//    OPTIMAL APPROACH:

    public static int dfsHeight(Node root){
        if(root == null) return 0;
        int left = dfsHeight(root.left);
        if(left == -1) return -1;
        int right = dfsHeight(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
    public static boolean isBalanced_OPTIMAL(Node root){
        return dfsHeight(root) != -1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println(isBalanced(root));
        System.out.println(isBalanced_OPTIMAL(root));
    }
}
