package BINARY_TREES;

import java.util.*;

public class _15BottomViewOfBT {

    public static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair<Node, Integer> p = q.poll();
            Node node = p.first;
            int hd = p.second;
            mpp.put(hd, node.data);
            if(node.left != null) q.offer(new Pair(node.left, hd-1));
            if(node.right != null) q.offer(new Pair(node.right, hd+1));
        }
        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        ArrayList<Integer> ans = bottomView(root);
        System.out.println(ans);
    }
}
