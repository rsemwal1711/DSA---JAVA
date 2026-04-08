package BINARY_TREES;

public class _7MaxDepthOfBT {
    public static int maxDepeth(TreeNode root){
        if(root == null) return 0;
        int lh = maxDepeth(root.left);
        int rh = maxDepeth(root.right);
        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        System.out.println(maxDepeth(root));
    }
}
