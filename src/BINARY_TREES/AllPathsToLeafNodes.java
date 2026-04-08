package BINARY_TREES;
import java.util.*;

public class AllPathsToLeafNodes {
    public static void allPathsToNodes(Node root, List<Integer> path, List<List<Integer>> ans){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(path));
        }
        else{
            allPathsToNodes(root.left, path, ans);
            allPathsToNodes(root.right, path, ans);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<List<Integer>> ans = new ArrayList<>();
        allPathsToNodes(root, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
