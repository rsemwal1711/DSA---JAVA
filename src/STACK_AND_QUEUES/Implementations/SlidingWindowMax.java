package STACK_AND_QUEUES.Implementations;

import java.util.*;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] arr, int k){
        int n = arr.length;
        int r = 0;
        int[] res = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peek() == i-k){
                q.pop();
            }
            while(!q.isEmpty() && arr[q.peek()] <= arr[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i >= k-1){
                res[r++] = arr[q.peek()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,2,5,10,7,4,3};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr,k)));
    }
}
