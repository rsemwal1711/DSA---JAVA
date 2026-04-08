package Binary_Search_Trees;

// insert at leaf node for this problem

public class _4InsertIntoBST {
    public static Node insertIntoBST(Node root, int val){
        if(root == null) return new Node(val);
        Node curr = root;
        while(true){
            if(curr.data <= val){
                if(curr.right != null) curr = curr.right;
                else{
                    curr.right = new Node(val);
                    break;
                }
            }
            else{
                if(curr.left != null) curr = curr.left;
                else{
                    curr.left = new Node(val);
                    break;
                }
            }
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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


        inorder(root);
        insertIntoBST(root, 11);
    }
}
