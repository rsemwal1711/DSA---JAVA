package STACK_AND_QUEUES.PrePostInFIX;

import java.util.Stack;

public class PREFIX_TO_INFOX {
    public static String prefixToInfix(String s){
        Stack<String> st = new Stack<>();
        int n = s.length();
        int i = n-1;
        while(i>=0){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(String.valueOf(c));
            }
            else{
                String t1 = st.peek();
                st.pop();
                String t2 = st.peek();
                st.pop();
                String con = '(' + t1 + c + t2 + ')';
                st.push(con);
            }
            i--;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String postFix = "*+PQ-MN";
        System.out.println(prefixToInfix(postFix));
    }
}
