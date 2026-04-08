package BINARY_TREES;

public class _21ChildrenSumPropInBT {
    public static void changeTree(Node root){
        if(root == null) return;
        int child = 0;
        if(root.left!=null) child += root.left.data;
        if(root.right!=null) child += root.right.data;

//        compare the sum of children with the current node's value and update.
        if(child >= root.data) root.data = child;
        else{
//            if sum is smaller update the child with current node's value;
            if(root.left != null) root.left.data = root.data;
            else if(root.right != null) root.right.data = root.data;
        }
        changeTree(root.left);
        changeTree(root.right);
        int total = 0;
        if(root.left != null) total += root.left.data;
        if(root.right != null) total += root.right.data;
        if(root.left != null || root.right != null) root.data = total;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
    }
}
