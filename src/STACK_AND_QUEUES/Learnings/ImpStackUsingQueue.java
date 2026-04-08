package STACK_AND_QUEUES.Learnings;
import java.util.*;

public class ImpStackUsingQueue {

    public static class Stack{
        Queue<Integer> q = new LinkedList<>();
        public void push(int x){
            int s = q.size();
            q.add(x);
            for(int i=0;i<s;i++){
                q.add(q.poll());
            }
        }
        public int pop(){
            int n = q.peek();
            q.poll();
            return n;
        }
        public void display(){
            for(int x : q){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(4);
        st.display();
        System.out.println(st.pop());
    }
}
