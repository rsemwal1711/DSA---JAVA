package BINARY_TREES;

import java.util.*;


public class _3PostOrderBinary {
    public List<Integer> result(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }
    public void postOrder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.data);
    }

    public List<Integer> iterative_approach(TreeNode root){
        List<Integer> postorder = new ArrayList<>();
        if(root == null) return postorder;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        TreeNode node = root;
        st1.push(node);
        while(!st1.isEmpty()){
            node = st1.pop();
            st2.add(node);
            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }
        while(!st2.isEmpty()){
            postorder.add(st2.pop().data);
        }
        return postorder;
    }

    public List<Integer> iterative_approachII(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(node != null || !st.isEmpty()){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    ans.add(temp.data);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.data);
                    }
                }
                else{
                    node = temp;
                }
            }
        }
        return ans;
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

        _3PostOrderBinary a = new _3PostOrderBinary();
        System.out.println(a.result(root));
        List<Integer> ans = a.iterative_approach(root);
        System.out.println(ans);

        List<Integer> ans2 = a.iterative_approachII(root);
        System.out.println(ans2);
    }
}
