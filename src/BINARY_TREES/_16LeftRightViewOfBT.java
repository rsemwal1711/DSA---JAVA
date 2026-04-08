package BINARY_TREES;

import java.util.*;

public class _16LeftRightViewOfBT {
    public static List<List<Integer>> levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            Integer[] level = new Integer[size];
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                level[i] = temp.data;
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            ans.add(Arrays.asList(level));
        }
        return ans;
    }
    public static List<Integer> levelOrder_LeftView(Node root){
        List<List<Integer>> ans = levelOrder(root);
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        for(List<Integer> it : ans){
            res.add(it.get(0));
        }
        return res;
    }
    public static List<Integer> levelOrder_RightView(Node root){
        List<List<Integer>> ans = levelOrder(root);
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        for(List<Integer> it : ans){
            res.add(it.get(it.size()-1));
        }
        return res;
    }
    public static void leftDFS(Node root, int level, List<Integer> res){
        if(root == null) return;
        if(res.size() == level) res.add(root.data);

        //interchange the below 2 line of code for rightView of the Binary Tree
        leftDFS(root.left, level+1, res);
        leftDFS(root.right, level+1, res);
    }
    public static List<Integer> leftView_Optimal(Node root){
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        leftDFS(root, 0, res);
        return res;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        List<Integer> leftView_LevelOrder = levelOrder_LeftView(root);
        System.out.println(leftView_LevelOrder);
        List<Integer> rightView_LevelOrder = levelOrder_RightView(root);
        System.out.println(rightView_LevelOrder);

        System.out.println();
        System.out.println("OPTIMAL APPROACH: ");
        List<Integer> res = leftView_Optimal(root);
        System.out.println(res);
    }
}
