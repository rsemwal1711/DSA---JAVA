package STACK_AND_QUEUES.PrePostInFIX;

import java.util.Stack;

public class POSTFIX_TO_INFIX {
    public static String postfixToInfix(String s){
        Stack<String> st = new Stack<>();
        int i = 0;
        int n = s.length();
        while(i<n){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(String.valueOf(c));
            }
            else{
                String t1 = st.peek();
                st.pop();
                String t2 = st.peek();
                st.pop();
                String con = '(' + t2 + c + t1 + ')';
                st.push(con);
            }
            i++;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String postFix = "AB-DE+F*/";
        System.out.println(postfixToInfix(postFix));
    }
}
