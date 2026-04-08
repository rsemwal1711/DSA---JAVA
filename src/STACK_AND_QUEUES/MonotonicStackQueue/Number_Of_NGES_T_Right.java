package STACK_AND_QUEUES.MonotonicStackQueue;

import java.util.Stack;

public class Number_Of_NGES_T_Right {
    public static int[] numberOfGreaterToRight(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=i+1;j<n;j++){
                if(arr[i] <arr[j]){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 5, 100, 9, 8, 10};
        int[] res = numberOfGreaterToRight(arr);
        for (int it : res) {
            System.out.print(it + " ");
        }
    }
}
