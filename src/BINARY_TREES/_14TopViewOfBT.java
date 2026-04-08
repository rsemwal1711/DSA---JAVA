package BINARY_TREES;
import java.util.*;

public class _14TopViewOfBT {

    public static ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> mpp = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair<Node, Integer> it = q.poll();
            Node temp = it.first;
            int hd = it.second;
            if(mpp.get(hd) == null) mpp.put(hd, temp.data);
            if(temp.left != null) q.offer(new Pair(temp.left, hd-1));
            if(temp.right != null) q.offer(new Pair(temp.right, hd+1));
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
        ArrayList<Integer> ans = topView(root);
        System.out.println(ans);
    }
}
