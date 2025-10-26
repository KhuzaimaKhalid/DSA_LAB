public class cll {
    private Node head;
    private Node tail;
    int size;

    public cll() {
        this.head = null;
        this.tail = null;
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
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }if(atFront){    // Q.1
            newNode.next = head;
            head = newNode;
        } else{     // Q.5

                Node temp = head;
//                while(temp.next != null){
//                    temp = temp.next;
//                }
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;

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
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = tail.next;
        tail = temp;



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

    public static void main(String[] args) {



    }


}