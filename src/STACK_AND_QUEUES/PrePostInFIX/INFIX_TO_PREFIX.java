package STACK_AND_QUEUES.PrePostInFIX;

import java.util.Stack;

public class INFIX_TO_PREFIX {

    public static void reverse(char[] arr){
        int n = arr.length;
        for(int i=0;i<n/2;i++){
            char temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;

            if(arr[i] =='(') arr[i] = ')';
            else if(arr[i] == ')') arr[i] = '(';
            if(arr[n-i-1] == '(') arr[n-i-1] = ')';
            else if(arr[n-i-1] == ')') arr[n-i-1] = '(';
        }
        if(n%2 == 1){
            int mid = n/2;
            if(arr[mid] == ')') arr[mid] = '(';
            else if(arr[mid] == '(') arr[mid] = ')';
        }
    }

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
                while(!st.isEmpty() && precedence(c) < precedence(st.peek())){
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
        char[] arr = res.toCharArray();
        reverse(arr);
        res = new String(arr);
        return res;
    }

    public static void main(String[] args) {
        String s = "(A+B)*C-D+F";
        char[] arr = s.toCharArray();
        reverse(arr);
        s = new String(arr);
        System.out.println(infixToPostFix(s));
    }
}
