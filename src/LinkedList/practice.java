package LinkedList;

class Node1{
    int data;
    Node1 next;
    public Node1(int data, Node1 next){
        this.data = data;
        this.next = next;
    }
    public Node1(int data){
        this.data = data;
        this.next = null;
    }
}
public class practice {
    public static Node1 insetAtEnd(Node1 head, int val){
        Node1 newNode1 = new Node1(val);
        if(head == null){
            return newNode1;
        }
        Node1 temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode1;
        return head;
    }
    public static Node1 deleteAtEnd(Node1 head){
        if(head == null) return null;
        Node1 temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    public static Node1 removeFromSpecificPosition(Node1 head, int pos){
        if(pos == 1){
            Node1 temp = head;
            head = head.next;
            temp = null;
            return head;
        }
        int count = 1;
        Node1 temp = head;
        while(temp!=null && count < pos-1){
            temp = temp.next;
            count++;
        }
        Node1 positionToRemove = temp.next;
        temp.next = temp.next.next;
        positionToRemove = null;
        return head;
    }
    public static Node1 reverseLL(Node1 head){
        Node1 prev = null;
        Node1 temp = head;
        while(temp!=null){
            Node1 front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public static void print(Node1 head){
        Node1 temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node1 head = new Node1(1);
        head = insetAtEnd(head,2);
        head = insetAtEnd(head,3);
        head = insetAtEnd(head,4);
        head = insetAtEnd(head,5);
        print(head);
//        System.out.println("AFTER REMOVING:");
//        head = deleteAtEnd(head);
//        head = removeFromSpecificPosition(head,4);
        head = reverseLL(head);
        print(head);
    }
}