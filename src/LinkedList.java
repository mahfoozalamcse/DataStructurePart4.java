
public class LinkedList {
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
    public static int size;

    // add first
    // add last

    public void addFirst(int data){
        // step 1 create new node
        Node newNode = new Node(data);
        size++;
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
        size++;
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
     // add in the Middle

    public void add(int idx, int data){
        if(idx == 0){ // when idx 0 pass
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;

        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        // i = idx-1; temp = prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // size of LinkedList

    // Remove Operation
    // Remove First
    // Remove Last

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove Last
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev : i = size - 2
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Iterative Search LL
    public int iterativeSearch(int key){
        Node temp = head;
        int i=0;

        while (temp != null){
            if(temp.data == key){  // key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        // key not found
        return  -1;
    }

    // search use Recursion
    public int helper(Node head, int key ){ // actual recursive function
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return  idx+1;
    }
    public int recursiveSearch(int key){
        return helper(head, key);
    }

    // Reverse a Linked List
    public void reverse(){
        Node prev = null;
        Node curr = tail = head; // java allocate back
        Node next;
        // 4 step and 3 variable

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find & Remove Nth node from End

    public void deleteNthFromEnd(int n){
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next; // remove first
            return;
        }
        // sz-n
        int i=1;
        int iToFind = sz -n;
        Node prev = head;
        while (i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // check LL is Palindrome
    // 1221  or 12221
    // learn from these question
    // learn slow fast concept
    // learn half reverse
    // learn 1/3 rd how reverse

    // step
    // find mid
    // 2nd half reverse
    // check if 1st half = 2nd half

    // slow-fast
    // slow +1
    // fast +2

    // slow fast approach to find mid

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2

        }
        return slow; // slow is my midNode
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // find mid
        Node midNode = findMid(head);

        // reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr  = next;
        }
        Node rightHalf = prev;  // right half head
        Node left = head;

        // check left and right half
        while (rightHalf != null){
            if(left.data != rightHalf.data){
                return false;
            }
            left = left.next;
            rightHalf = rightHalf.next;
        }
        return true;
    }

   // Detect loop/Cycle in LL
    public static boolean isCycle() { // also floyed  cycle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next !=null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if(slow == fast){
                return true;  // cycle exist
            }
        }
        return false; // cycle does not exist
    }

    // Remove a loop/Cycle in LL
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
            if(cycle == false){
                return;
            }
            // find meeting point
            slow = head;
            Node prev = null; // last node
            while (slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            // remove cycle
            prev.next = null;
        }
    // Java Collection Frame work
    // merge sort
    // merge Sort in LL
    // step
    // middle
    // left half
    // right half
    // merge
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow; // get mid
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;

        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left and right
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    // print Zig Zag LinkedList
    // find mid
    // reverse left half and right half
    // alternate merging
    public void zigZag(){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alt merge zigzag
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;

        }
    }



    public static void main(String[] args) {
       LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.zigZag();
        ll.print();



//       ll.addFirst(1);
//       ll.addFirst(2);
//       ll.addFirst(3);
//       ll.addFirst(4);
//       ll.addFirst(5);
//
//        ll.print();
//        ll.head = ll.mergeSort(ll.head);
//        ll.print();





//        head = new Node(1);
//        Node temp = new Node(2);
//        head.next = temp;
//        head.next.next = new Node(3);
//        head.next.next.next = temp;

        // 1->2->3->2
//        System.out.println(isCycle());
//        removeCycle();
//        System.out.println(isCycle());


     //   System.out.println(isCycle());




//        LinkedList ll = new LinkedList();
//   //     ll.print();
//        ll.addFirst(1);
//    //    ll.print();
//        ll.addFirst(2);
//        ll.add(1, 87);
//      //  ll.print();
//        ll.addLast(3);
//      //  ll.print();
//        ll.addLast(4);
//       ll.print();

//        ll.removeFirst();
//        ll.print();
//        ll.removeLast();
//        ll.print();
//        System.out.println(ll.size);
//        System.out.println(ll.recursiveSearch(87));
//        System.out.println(ll.recursiveSearch(10));

//
        //   System.out.println(ll.checkPalindrome());
        


        }

}
