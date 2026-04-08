package BINARY_TREES;

import java.util.*;


public class _4PreOrderBinary {
    public List<Integer> result(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }
    public void postOrder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        ans.add(root.data);
        postOrder(root.left, ans);
        postOrder(root.right, ans);
    }

    public List<Integer> iterative_approach(TreeNode root){
        List<Integer> preOrder = new ArrayList<>();
        if(root == null) return preOrder;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            preOrder.add(node.data);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }
        return preOrder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        _4PreOrderBinary a = new _4PreOrderBinary();
        System.out.println(a.result(root));

        List<Integer> ans = a.iterative_approach(root);
        System.out.println(ans);
    }
}
