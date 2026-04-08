package BINARY_TREES;

public class _9DiameterOfTree {
    static int diameter = 0;
    public static int calculateHeight(Node root){
        if(root == null) return 0;
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);
        diameter = Math.max(diameter, left+right);
        return 1+Math.max(left, right);
    }
    public static int diameterOfBinaryTree(Node root){
        calculateHeight(root);
        return diameter;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println(diameterOfBinaryTree(root));
    }
}