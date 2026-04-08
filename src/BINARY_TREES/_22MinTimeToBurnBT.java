package BINARY_TREES;

import java.util.*;

public class _22MinTimeToBurnBT {
    public static Node abc(Node root, Map<Node, Node> mpp, int start){
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        Node res = null;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                if(temp.data == start){
                    res = temp;
                }
                if(temp.left!=null){
                    mpp.put(temp.left, temp);
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    mpp.put(temp.right, temp);
                    q.offer(temp.right);
                }
            }
        }
        return res;
    }
    public static int findMaxDistance(Map<Node, Node> mpp, Node target){
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        Map<Node, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int f1 = 0;
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                if(temp.left != null && vis.get(temp.left) == null){
                    f1 = 1;
                    vis.put(temp.left, 1);
                    q.offer(temp.left);
                }
                if(temp.right != null && vis.get(temp.right) == null){
                    f1 = 1;
                    vis.put(temp.right, 1);
                    q.offer(temp.right);
                }
                if(mpp.get(temp) != null && vis.get(mpp.get(temp)) == null){
                    f1 = 1;
                    vis.put(mpp.get(temp), 1);
                    q.offer(mpp.get(temp));
                }
            }
            if(f1 == 1){
                maxi++;
            }
        }
        return maxi;
    }
    public static int minTimeToBurn(Node root, int target){
        Map<Node, Node> mpp = new HashMap<>();
        Node res = abc(root, mpp, target);
        int maxi = findMaxDistance(mpp, res);
        return maxi;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        System.out.println(minTimeToBurn(root, 2));
    }
}
