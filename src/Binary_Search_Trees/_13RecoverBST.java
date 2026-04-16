package Binary_Search_Trees;

public class _13RecoverBST {
    public static Node first, prev, middle, last;
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && prev.data > root.data){
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    public static void recoverTree(Node root){
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        inorder(root);
        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if(first != null & middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
    public static void Inorder(Node root){
        if(root == null) return;
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(8);

        root.left.left = new Node(2);
        root.left.right = new Node(12);

        root.right.left = new Node(7);
        root.right.right = new Node(9);

        root.left.left.left = new Node(1);

        root.right.left.left = new Node(6);
        root.right.right.right = new Node(10);

        Inorder(root);
        System.out.println();
        recoverTree(root);
        Inorder(root);
    }
}
