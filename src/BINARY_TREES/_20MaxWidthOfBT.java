package BINARY_TREES;

import java.util.LinkedList;
import java.util.Queue;

class Pairs{
    Node node;
    int num;
    Pairs(Node node, int num){
        this.node = node;
        this.num = num;
    }
}
public class _20MaxWidthOfBT {
    public static int widthOfBinaryTree(Node root){
        if(root == null) return 0;
        int ans = 0;
        Queue<Pairs> q = new LinkedList<>();
        q.offer(new Pairs(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;
            int first = 0;
            int last = 0;
            for(int i=0;i<size;i++){
                int curr_id = q.peek().num - mmin;
                Node node = q.peek().node;
                q.poll();
                if(i == 0) first = curr_id;
                if(i == size-1) last = curr_id;
                if(node.left != null){
                    q.offer(new Pairs(node.left, 2*curr_id + 1));
                }
                if(node.right != null){
                    q.offer(new Pairs(node.left, 2*curr_id + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
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
        System.out.println(widthOfBinaryTree(root));
    }
}