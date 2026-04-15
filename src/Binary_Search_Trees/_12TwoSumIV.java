package Binary_Search_Trees;
import java.util.*;

class BstIterator{
    Stack<Node> st;
    boolean reverse = false;
    BstIterator(Node root, boolean isReverse){
        st = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }
    public boolean hasNext(){
        return !st.isEmpty();
    }
    public int next(){
        Node tmpNode = st.pop();
        if(!reverse) pushAll(tmpNode.right);
        else pushAll(tmpNode.left);
        return tmpNode.data;
    }
    public void pushAll(Node node){
        while(node!=null){
            st.push(node);
            if(reverse) node = node.right;
            else node = node.left;
        }
    }
}
public class _12TwoSumIV {
    public static boolean findTarget(Node root, int k){
        if(root == null) return false;
        BstIterator l = new BstIterator(root, false);
        BstIterator r = new BstIterator(root, true);
        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
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
        System.out.println(findTarget(root, 14));
    }
}
