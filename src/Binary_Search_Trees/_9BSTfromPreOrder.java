package Binary_Search_Trees;

public class _9BSTfromPreOrder {

    static int idx = 0;
    public static Node build(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] >= bound) {
            return null;
        }

        Node root = new Node(preorder[idx++]);

        root.left = build(preorder, root.data);
        root.right = build(preorder, bound);

        return root;
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        Node root = build(preorder, Integer.MAX_VALUE);
        inorder(root);
    }
}
