package LinkedList;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node(int data, int next){
        this.data = data;
        this.next = null;
    }
}

public class Remove_Specific_Val {
    public static Node deleteByValue(Node head, int key){
        if(head == null){
            System.out.println("List is empty");
            return null;
        }
        if(head.data == key){
            Node temp = head;
            head = head.next;
            temp = null;
            return head;
        }
        Node curr = head;
        while(curr.next != null && curr.next.data!=key){
            curr = curr.next;
        }
        if(curr.next == null){
            return head;
        }
        Node nodeToDelete = curr.next;
        curr.next = curr.next.next;
        nodeToDelete = null;
        return head;
    }

    public static Node insertEnd(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        return head;
    }
    public static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        Node head = new Node(23);
//        head.next = new Node(42);
//        head.next.next = new Node(32);
        Node head = new Node(12);
        head = insertEnd(head,23);
        head = insertEnd(head,42);

        head = deleteByValue(head, 23);
        print(head);
    }
}