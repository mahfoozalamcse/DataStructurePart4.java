import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Linked List

    public static class Node{
        int data;
        Node next;

        public  Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // head and tail in LL
    // tail last which store last data

    public static Node head;
    public static Node tail;

    // add first
    // add last

    public void addFirst(int data){
        // step 1 create new node
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        // step 2 newNode.next = head
        newNode.next = head; // link
        // step3
        head = newNode;

    }

    // add last
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // print LinkedList
     public void print(){
        if(head == null){
            System.out.print("LL is Empty");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
      //  ll.print();
        ll.addFirst(1);
      //  ll.print();
        ll.addFirst(2);
     //   ll.print();
        ll.addLast(3);
      //  ll.print();
        ll.addLast(4);
      //  ll.print();
    }
}