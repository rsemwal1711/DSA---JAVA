package BINARY_TREES;
import java.util.*;

public class _28MorrisTraversals {
    public static List<Integer> getInorder(Node root){
        List<Integer> inorder = new ArrayList<>();
        if(root == null) return inorder;
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                inorder.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right!=null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    inorder.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }

    public static List<Integer> getPreorder(Node root){
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                preorder.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right!=null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.data);
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        List<Integer> inorder = getInorder(root);
        System.out.println(inorder);
        List<Integer> preorder = getPreorder(root);
        System.out.println(preorder);
    }
}
