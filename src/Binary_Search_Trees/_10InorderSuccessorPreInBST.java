package Binary_Search_Trees;

public class _10InorderSuccessorPreInBST {
    public static Node inorderSuccessor(Node root, Node p){
        Node successor = null;
        while(root != null){
            if(p.data >= root.data){
                root = root.right;
            }
            else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
    public static Node inorderPredecessor(Node root, Node p){
        Node predecessor = null;
        while(root != null){
            if(p.data <= root.data){
                predecessor = root;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return predecessor;
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

        Node successor = inorderSuccessor(root, root.right.left);
        Node predecessor = inorderPredecessor(root, root.right.left);
        System.out.println(successor.data + " " + predecessor.data);
    }
}