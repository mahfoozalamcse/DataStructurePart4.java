import java.util.LinkedList;
// Array List
// LinkedList
// stack
// Queue
// Hash set
// Hash map
// etc. more exist when not say scratch not make use exiting than use java collection
// jcf optimized already in scratch we handle self corner case and optimized

public class Collections {



    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);

        System.out.println(ll);
        ll.removeLast();
        ll.removeFirst();

        System.out.println(ll);

    }
}
