package Binary_Search_Trees;

import java.util.*;

public class _11BSTIterator_Optimal {
    Stack<Node> st = new Stack<>();
    _11BSTIterator_Optimal(Node root){
        pushAll(root);
    }
    public boolean hasnext(){
        return !st.isEmpty();
    }
    public int next(){
        Node tmpNode = st.pop();
        pushAll(tmpNode.right);
        return tmpNode.data;
    }
    public void pushAll(Node root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
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

        _11BSTIterator_Optimal a = new _11BSTIterator_Optimal(root);
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
        System.out.println(a.next());
        System.out.println(a.hasnext());

    }
}
