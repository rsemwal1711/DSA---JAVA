package BINARY_TREES;

import java.util.Stack;

/*
this way make all the nodes left pointers to null and all just having the right pointers :
1
 2
  3
   4
    5
     6
 */
public class _29FlattenBTtoLL {

//    Recursion :

    static Node prev = null;
    public static void flatten(Node root){
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

//    Using Stack :
    public static void flatten_Stack(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node curr = st.pop();
            if(curr.right!=null) st.push(curr.right);
            if(curr.left!=null) st.push(curr.left);
            if(!st.isEmpty()) curr.right = st.peek();
            curr.left = null;
        }
    }

    // Morris Traversal :
    public static void flatten_MorrisTraversal(Node root){
        if(root == null) return;
        Node curr = root;
        while(curr!=null){
            if(curr.left != null){
                Node prev = curr.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }
    }
    public static void printFlattenTree(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        printFlattenTree(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        //flatten(root);
        //flatten_Stack(root);
        flatten_MorrisTraversal(root);
        printFlattenTree(root);
    }
}