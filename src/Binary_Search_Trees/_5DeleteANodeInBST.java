package Binary_Search_Trees;
// BST CODE :

public class _5DeleteANodeInBST {
    public static Node helper(Node root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        else{
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    public static Node findLastRight(Node root){
        if(root.right == null) return root;
        return findLastRight(root.right);
    }
    public static Node deleteNode(Node root, int key){
        if(root == null) return null;
        if(root.data == key){
            return helper(root);
        }
        Node dummy = root;
        while(root!=null){
            if(root.data > key){
                if(root.left != null && root.left.data == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right!=null && root.right.data == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
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

        Node delete = deleteNode(root, 6);
        inorder(root);
    }
}
