import java.util.Stack;
public class singlyLinkedList {
    private Node head;
    int size;

    public singlyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Q.4
    void display(){
        if(isEmpty()){
            System.out.println("Linked List is Empty");
        }
        Node node = head;
        while(node != null){
            System.out.println(" "+node.data);
            node = node.next;
        }
    }
        //   Q.1 + Q.5
    void Insert(int data, boolean atFront){
        Node node = new Node(data);
        if(atFront){    // Q.1
            node.next = head;
            head = node;
        } else{     // Q.5
            if(head == null) {
                head = node;
            } else {
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = node;
            }
        }
        size++;
    }

    void Insert(int data){
        Insert(data,false);
    }

    // Q.3
    void deleteFirst(boolean atFront){
        head = head.next;
    }

    // Q.6
    void deleteLast(){
        if(head == null){
            System.out.println("Error due to empty list");
            return;
        }
        if(head.next == null) {
            System.out.println("Only one node");
            head = null;
            return;
        }
        Node currentNode = head;
        while(currentNode.next.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = null;
    }

    //          Q.7
    void InsertPosition(int data, int pos){
        if(pos < 0){
            System.out.println("Error due to invalid position");
            return;
        }
        Node temp = head;
        int j = 0;
        while(j < pos-1){
            temp = temp.next;
            j++;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

    }

    //         Q.8
    void deletePosition(int pos){

        Node temp = head;
        int j = 1;
        while(j < pos){
            temp = temp.next;
            j++;
        }
        temp.next = temp.next.next;
    }

    //         Q.9
   void reverseList(){
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
   }

   //         Q.10
    int min(){
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        Node current = head;
        int min = current.data;

        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }

        return min;
    }

    //          Q.11
    int max(){
        if (head == null) {
            System.out.println("List is empty");
            return -1; // or throw an exception
        }

        Node current = head;
        int max =  current.data; // Start with first element as minimum

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    //          Q.12
    public int search(int DATA)
    {
        int pos=-1;
        if(this.head==null)
        {
            System.out.println("List is empty");
            return pos;
        }
        Node currNode = this.head;
        pos=0;

        while (currNode != null) {
            if(currNode.data==DATA){
                System.out.println("Data is found at position: "+ pos);
                return pos;
            }
            pos++;
            currNode = currNode.next;
        }
        System.out.println("Data is not in the list \n");
        return pos;
    }

    // Easy way: Check if the linked list is a palindrome using a stack
    boolean isPalindrome() {
        if (head == null) {
            return true;
        }

        // Step 1: Push all elements into a stack
        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        // Step 2: Pop from stack and compare with list elements
        temp = head;
        while (temp != null) {
            if (temp.data != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {

        singlyLinkedList list = new singlyLinkedList();

        // Q.1 + Q.5 - Testing Insert at front and end
        System.out.println("=== Q.1 + Q.5 - Testing Insert at front and end ===");
        list.Insert(30);
        list.Insert(20);
        list.Insert(10, true);
        list.Insert(40);
        list.display();

        // Q.3 - Delete first
        System.out.println("\n=== Q.3 - Delete first ===");
        list.deleteFirst(true);
        list.display();

        // Q.6 - Delete last
        System.out.println("\n=== Q.6 - Delete last   ===");
        list.deleteLast();
        list.display();

        // Q.7 - Insert at position
        System.out.println("\n=== Q.7 - Insert at position ===");
        list.InsertPosition(25, 1);
        list.display();

        // Q.8 - Delete at position
        System.out.println("\n=== Q.8 - Delete at position ===");
        list.deletePosition(1);
        list.display();

        // Q.9 - Reverse list
        System.out.println("\n=== Q.9 - Reverse list ===");
        list.Insert(40);
        list.display();
        list.reverseList();
        list.display();

        // Q.10 + Q.11 - Min and Max
        System.out.println("\n=== Q.10 + Q.11 - Min and Max ===");
        System.out.println("Min: " + list.min());
        System.out.println("Max: " + list.max());

        // Q.12 - Search
        System.out.println("\n=== Q.12 - Search ===");
        list.search(30);
        list.search(99);

    }


}
