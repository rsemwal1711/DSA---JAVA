package Binary_Search_Trees;

public class _2Floor_Ceil {
    public static int floor(Node root, int val){
        int floor = -1;
        while(root!=null){
            if(root.data == val){
                floor = root.data;
                return floor;
            }
            if(root.data < val){
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
    }
    public static int ceil(Node root, int val){
        int ceil = -1;
        while(root!=null){
            if(root.data == val){
                ceil = root.data;
                return ceil;
            }
            if(root.data > val){
                ceil = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;
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
        root.right.right.right = new Node(11);

        System.out.println(floor(root, 10));
        System.out.println(ceil(root, 10));
    }
}
