package STACK_AND_QUEUES.PrePostInFIX;
import java.util.*;
public class POSTFIX_TO_PREFIX {
    public static String postfixToPrefix(String s){
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
                String con = c+t2+t1;
                st.push(con);
            }
            i++;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String postFix = "AB-DE+F*/";
        System.out.println(postfixToPrefix(postFix));
    }
}
