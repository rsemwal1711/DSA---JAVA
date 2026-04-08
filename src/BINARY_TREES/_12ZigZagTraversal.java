package BINARY_TREES;

import java.util.*;

class _12ZigZagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            Integer[] level = new Integer[size];
            for(int i=0;i<size;i++){
                Node node = q.poll();
                int index = leftToRight ? i : size-i-1;
                level[index] = node.data;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            leftToRight = !leftToRight;
            result.add(Arrays.asList(level));
        }
        return result;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        List<List<Integer>> a = zigzagLevelOrder(root);
        System.out.println(a);
    }
}
