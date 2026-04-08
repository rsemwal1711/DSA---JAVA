package Binary_Search_Trees;

public class _3Max_Min {
    public static int maxInBST(Node root){
        if(root == null) return -1;
        while(root.right!=null){
            root = root.right;
        }
        return root.data;
    }
    public static int minInBST(Node root){
        if(root == null) return -1;
        while(root.left!=null){
            root = root.left;
        }
        return root.data;
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

        System.out.println(minInBST(root));
        System.out.println(maxInBST(root));
    }
}
