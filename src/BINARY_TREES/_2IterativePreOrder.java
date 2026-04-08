package BINARY_TREES;

import java.util.*;

// ROOT LEFT RIGHT;
//       1
//    2     3
//  4  5   6  7

public class _2IterativePreOrder {
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            root = st.pop();
            ans.add(root.data);
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        _2IterativePreOrder a = new _2IterativePreOrder();
        System.out.println(preOrder(root));
    }
}
