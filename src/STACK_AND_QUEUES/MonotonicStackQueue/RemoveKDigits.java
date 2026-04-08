package STACK_AND_QUEUES.MonotonicStackQueue;

import java.util.*;

public class RemoveKDigits {
    public static String removeKdigits(String num,int k){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && st.peek() >= num.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        while(ans.length()>0 && ans.charAt(ans.length()-1) == '0'){
            ans.deleteCharAt(ans.length()-1);
        }
        ans.reverse();
        if(ans.length() == 0) return "0";
        return ans.toString();
    }
    public static void main(String[] args) {
        String num = "1432219";
        System.out.println(removeKdigits(num,3));
    }
}
