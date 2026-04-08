package STACK_AND_QUEUES.MonotonicStackQueue;

import java.util.Stack;

public class Next_Smaller {
    public static int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

//        for linear:

//        for(int i=n-1;i>=0;i--){
//            while(!st.isEmpty() && arr[i] <= st.peek()){
//                st.pop();
//            }
//            if(st.isEmpty()) res[i] = -1;
//            else res[i] = st.peek();
//            st.push(arr[i]);
//        }

//        for circular condition:

        for(int i=2*n-1;i>=0;i--){
            int ind = i%n;
            while(!st.isEmpty() && arr[ind] <= st.peek()){
                st.pop();
            }
            if(i<n) {
                if (st.isEmpty()) res[ind] = -1;
                else res[ind] = st.peek();
            }
            st.push(arr[ind]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,9,7,5,8,4,10};
        int[] res = nextSmaller(arr);
        for(int it : res){
            System.out.print(it + " ");
        }
    }
}
