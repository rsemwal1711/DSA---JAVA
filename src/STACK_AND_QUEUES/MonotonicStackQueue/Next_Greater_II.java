package STACK_AND_QUEUES.MonotonicStackQueue;
import javax.xml.transform.stax.StAXResult;
import java.util.*;

public class Next_Greater_II {

    public static int[] nextGreaterII_BRUTE(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++){
            int currEle = arr[i];
            for(int j=1;j<n;j++){
                int ind = (i+j)%n;
                if(arr[ind] > currEle){
                    res[i] = arr[ind];
                    break;
                }
            }
        }
        return res;
    }

    public static int[] nextGreaterII_OPTIMAL(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            int ind = i%n;
            int currEle = arr[ind];
            while(!st.isEmpty() && currEle >= st.peek()){
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()) res[ind] = -1;
                else res[ind] = st.peek();
            }
            st.push(currEle);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2,10,12,1,11};
//        int[] res = nextGreaterII_BRUTE(arr);

        int[] res = nextGreaterII_OPTIMAL(arr);
        for (int it : res) {
            System.out.print(it + " ");
        }
    }
}