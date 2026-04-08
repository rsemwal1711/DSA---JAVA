package BINARY_TREES;
import java.util.*;

public class _13BoundaryLevelTraversal {
    public static boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }

//    function to add the left boundary of the tree
    public static void addLeft_boundary(Node root, List<Integer> res){
        Node curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)) res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

//    function to add the left boundary of the tree
    public static void addRight_boundary(Node root, List<Integer> res){
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }

//    function to add leaves
    public static void addLeaves(Node root, List<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null){
            addLeaves(root.left, res);
        }
        if(root.right != null){
            addLeaves(root.right, res);
        }
    }

    public static List<Integer> printBoundary(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        if(!isLeaf(root)) res.add(root.data);
        addLeft_boundary(root, res);
        addLeaves(root, res);
        addRight_boundary(root, res);
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        List<Integer> res = printBoundary(root);
        System.out.println(res);

    }
}


//508, 15,22,46,78,17

//912, 215, 33,148

// 136, 191, 338, 268

// 217, 1, 249, 349,387,242

// 20, 155,739,150

// 232,933,225  x