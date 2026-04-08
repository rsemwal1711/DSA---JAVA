package BINARY_TREES;

import java.util.*;

public class _1InOrderBinary {
    public List<Integer> result(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }
    public void inOrder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }

    public List<Integer> iteratice_appraoch(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        if(root == null) return inorder;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else {
                if (st.isEmpty()) break;
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
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

        _1InOrderBinary a = new _1InOrderBinary();
        System.out.println(a.result(root));

        List<Integer> ans = a.iteratice_appraoch(root);
        System.out.println(ans);
    }
}
