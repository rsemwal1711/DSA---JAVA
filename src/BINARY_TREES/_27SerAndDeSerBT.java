package BINARY_TREES;

import java.util.*;

public class _27SerAndDeSerBT {
    public static String serialize(Node root){
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp == null){
                res.append("# ");
                continue;
            }
            res.append(temp.data).append(" ");
            q.add(temp.left);
            q.add(temp.right);
        }
        return res.toString();
    }

    public static Node deserialize(String data){
        if(data.isEmpty()) return null;
        Queue<Node> q = new LinkedList<>();
        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            Node parent = q.poll();
            if(!values[i].equals("#")){
                Node left = new Node(Integer.parseInt(values[i]));
                if(parent != null) parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("#")){
                Node right = new Node(Integer.parseInt(values[i]));
                if(parent != null) parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(13);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        System.out.println(serialize(root));
        preorder(root);
    }
}
