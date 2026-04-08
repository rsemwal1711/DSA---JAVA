package BINARY_TREES;

public class _10MaximumSumPath {
    static int maxSum = Integer.MIN_VALUE;
    public static int dfs(Node root){
        if(root == null) return  0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        maxSum = Math.max(maxSum, left+right+root.data);
        return root.data + Math.max(left, right);
    }
    public static int maxPathSum(Node root){
        dfs(root);
        return maxSum;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println(maxPathSum(root));
    }
}