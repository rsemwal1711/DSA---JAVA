package BINARY_TREES;

import java.util.*;

public class _21PrintAllNodesAtDisK {
    public static List<Integer> distanceK(Node root, Node target, int k){
        if(root == null) return new ArrayList<>();
        Map<Node, Node> parentMap = new HashMap<>();
        mapParents(root, parentMap);
        return bfsFromTarget(target, parentMap, k);
    }
    public static void mapParents(Node root, Map<Node, Node> parentMap){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left != null){
                parentMap.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
    public static List<Integer> bfsFromTarget(Node target, Map<Node, Node> parentMap, int k){
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int currLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel == k) break;
            else currLevel++;
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.offer(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.offer(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    visited.add(parentMap.get(node));
                    q.offer(parentMap.get(node));
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().data);
        }
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
        List<Integer> ans = distanceK(root, root.left.right, 2);
        System.out.println(ans);
    }
}