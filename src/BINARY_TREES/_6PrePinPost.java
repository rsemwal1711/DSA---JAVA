package BINARY_TREES;

import java.util.*;

public class _6PrePinPost {
    public static List<List<Integer>> preInPost(TreeNode root){
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(root == null) return new ArrayList<>();

        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        st.push(new Pair<> (root, 1));
        while(!st.isEmpty()){
            Pair<TreeNode, Integer> it = st.pop();
            if(it.second == 1){
                pre.add(it.first.data);
                it.second = 2;
                st.push(it);
                if(it.first.left != null){
                    st.push(new Pair<>(it.first.left, 1));
                }
            }
            else if(it.second == 2){
                in.add(it.first.data);
                it.second = 3;
                st.push(it);
                if(it.first.right != null){
                    st.push(new Pair<>(it.first.right, 1));
                }
            }
            else{
                post.add(it.first.data);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(pre);
        res.add(in);
        res.add(post);
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        System.out.println(preInPost(root));

    }
}
