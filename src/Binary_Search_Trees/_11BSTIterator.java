package Binary_Search_Trees;

import java.util.*;

class _11BSTIterator {
     List<Integer> res;
     int index;
    _11BSTIterator(Node root){
        res = new ArrayList<>();
        index = 0;
        inorder(root);
    }
    // Brute force approach :
    public void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        res.add(root.data);
        inorder(root.right);
    }
    public int next(){
        return res.get(index++);
    }
    public boolean hasnext(){
        return index<res.size();
    }
    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(8);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(7);
        root.right.right = new Node(9);

        root.left.left.left = new Node(1);

        root.right.left.left = new Node(6);
        root.right.right.right = new Node(10);

        _11BSTIterator a = new _11BSTIterator(root);
        System.out.println(a.next());
        System.out.println(a.next());
        System.out.println(a.next());
        System.out.println(a.next());
        System.out.println(a.next());
        System.out.println(a.next());
        System.out.println(a.next());
        System.out.println(a.next());
        System.out.println(a.next());
        System.out.println(a.next());

        System.out.println(a.hasnext());
    }
}
