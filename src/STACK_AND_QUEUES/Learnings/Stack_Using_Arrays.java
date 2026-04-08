package STACK_AND_QUEUES.Learnings;

import java.util.Stack;

public class Stack_Using_Arrays {
    int size = 10000;
    int[] arr = new int[size];
    int top = -1;
    public void push(int val){
        top++;
        arr[top] = val;
    }
    public int pop(){
        int x = arr[top];
        top--;
        return x;
    }
    public int top(){
        return arr[top];
    }
    public int size(){
        return top+1;
    }
    public void print(){
        for(int i=0;i<=top;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack_Using_Arrays st = new Stack_Using_Arrays();
        st.push(12);
        st.push(78);
        st.push(46);
        st.push(34);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.size());
        st.print();
    }
}