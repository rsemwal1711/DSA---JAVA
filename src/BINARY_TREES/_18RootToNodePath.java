package BINARY_TREES;
import java.util.*;

public class _18RootToNodePath {
    public static boolean getPath(Node root, List<Integer> res, int x){
        if(root == null) return false;
        res.add(root.data);
        if(root.data == x) return true;
        if(getPath(root.left, res, x) || getPath(root.right, res, x)) return true;
        res.remove(res.size()-1);
        return false;
    }
    public static List<Integer> solve(Node root, int x){
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        getPath(root, res, x);
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
        List<Integer> res = solve(root, 7);
        System.out.println(res);
    }
}
