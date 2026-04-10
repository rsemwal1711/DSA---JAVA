package Binary_Search_Trees;

public class _8LCAinBST {
    public static Node lca(Node root, Node p, Node q){
        if(root == null) return null;
        int val = root.data;
        if(val < p.data && val < q.data){
            return lca(root.right, p, q);
        }
        if(val > p.data && val > q.data){
            return lca(root.left, p, q);
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

        Node a = lca(root, root.right.left, root.right.right.right);
        System.out.println(a.data);
    }
}
