package STACK_AND_QUEUES.PrePostInFIX;
import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.*;

public class INFIX_TO_POSTFIX {
    public static int precedence(char c){
        switch (c){
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    public static String infixToPostFix(String infix){
        String res = "";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<infix.length();i++){
            char c = infix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                res += c;
            }
            else if(c == '('){
                st.push(c);
            }
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    res += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && precedence(c) <= precedence(st.peek())){
                    res += st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            if(st.peek() == '('){
                return "INVALID EXPRESSION";
            }
            res += st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(infixToPostFix("a+b*(c^d-e)"));
    }
}
