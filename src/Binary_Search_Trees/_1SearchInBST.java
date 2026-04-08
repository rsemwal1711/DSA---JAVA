package Binary_Search_Trees;

public class _1SearchInBST {
    public static Node searchBST(Node root, int val){
        while(root != null && root.data != val){
            root = val < root.data ? root.left : root.right;
        }
        return root;
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

        Node ans = searchBST(root, 7);
        System.out.println(ans.data);
    }
}
