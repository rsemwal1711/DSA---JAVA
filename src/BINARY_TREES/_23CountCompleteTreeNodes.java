package BINARY_TREES;

public class _23CountCompleteTreeNodes {
    public static int leftHeight(Node root){
        int count = 0;
        while(root!=null){
            count++;
            root = root.left;
        }
        return count;
    }
    public static int rightHeight(Node root){
        int count = 0;
        while(root!=null){
            count++;
            root = root.right;
        }
        return count;
    }
    public static int countNodes(Node root){
        if(root == null) return 0;
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println(countNodes(root));
    }
}
