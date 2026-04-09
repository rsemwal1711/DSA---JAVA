package Binary_Search_Trees;
import java.util.*;

public class _6KthSmallestElInBST {
    public static void inorder(Node root, List<Integer> ans){
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
    public static int kthSmallest_brute(Node root, int k){
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        Collections.sort(ans);
        return ans.get(k-1);
    }

    public static int kthSmallest_Morris_Optimal(Node root, int k){
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                if(--k == 0) return curr.data;
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    if(--k == 0) return curr.data;
                    curr = curr.right;
                }
            }
        }
        return -1;
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

        System.out.println(kthSmallest_brute(root, 4));
        System.out.println(kthSmallest_Morris_Optimal(root, 6));
    }
}
