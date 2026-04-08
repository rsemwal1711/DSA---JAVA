package BINARY_TREES;
import java.util.*;

public class _25PreAndInorderBT {
    public static Node build(int[] preOrder, int preStart, int preEnd, int[] inOrder,
      int inStart, int inEnd, Map<Integer, Integer> inMap)
    {
        if(preStart > preEnd || inStart > inEnd) return null;
        Node root = new Node(preOrder[preStart]);

        int inRoot = inMap.get(root.data);
        int numLeft = inRoot - inStart;

        root.left = build(preOrder, preStart+1, preStart+numLeft, inOrder, inStart, inRoot-1, inMap);
        root.right = build(preOrder, preStart+numLeft+1, preEnd, inOrder, inRoot+1, inEnd, inMap);

        return root;
    }
    public static Node buildTree(int[] preOrder, int[] inorder){
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }
        return build(preOrder, 0, preOrder.length-1, inorder, 0, inorder.length-1, inMap);
    }
    public static void print(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
        int[] inorder = {40,20,50,10,60,30};
        int[] preorder = {10,20,40,50,30,60};
        Node a = buildTree(preorder, inorder);
        print(a);
    }
}
