package Binary_Search_Trees;

public class _14LargestBSTCount {
        public static boolean isValidBST(Node root, long minValue, long maxValue){
            if(root == null) return true;
            if(root.data >= maxValue || root.data <= minValue) return false;
            return isValidBST(root.left, minValue, root.data) && isValidBST(root.right, root.data, maxValue);
        }
        public static int countNodes(Node root){
            if(root == null) return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        public static int largestBST(Node root){
            if(root == null) return 0;
            if(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)){
                return countNodes(root);
            }
            return Math.max(largestBST(root.left), largestBST(root.right));
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
        System.out.println(largestBST(root));
    }
}
