package STACK_AND_QUEUES.MonotonicStackQueue;

import java.util.*;

public class Next_Greater_El {
    public static int[] nextGreaterI(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();
            st.push(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,7,5,100,9,8,10};
        int[] res = nextGreaterI(arr);
        for(int it : res){
            System.out.print(it + " ");
        }
    }
}