public class singlyLinkedList_Test2 {
    private Node head;
    int size;

    public singlyLinkedList_Test2() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }
// Q.1 + Q.5
    void Insert(int DATA, boolean atFront){
        Node newNode = new Node(DATA);
        if(atFront){
            newNode.next = head;
            head = newNode;
        } else{
            if(head == null){
                head = newNode;
            } else{
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        size++;
    }
    void Insert(int DATA){
        Insert(DATA,false);
    }

    // Q.3
    void deleteFirst(){
        head = head.next;
    }
    // Q.4
    void display(){
        if(isEmpty()){
            System.out.println("error in display");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.println(" "+temp.data);
            temp = temp.next;
        }
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
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    // Q.7
void InsertPosition(int DATA, int pos){
        if(pos < 0){
            System.out.println("error in insertPosition");
            return;
        }
        Node temp = head;
        int j = 0;
        while(j < pos-1){
            temp = temp.next;
            j++;
        }
        Node newNode = new Node(DATA);
        newNode.next = temp.next;
        temp.next = newNode;
}

// Q.8
    void deletePosition(int pos){
        if(pos < 0){
            System.out.println("error in deletePosition");
            return;
        }
        Node temp = head;
        int j = 1;
        while(j < pos){
            temp = temp.next;
            j++;
        }
        temp.next = temp.next.next;
    }

    // Q.9
    void reverse(){
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

    // Q.10
int max(){
        if(head == null){
            System.out.println("error in max");
            return -1;
        }
        Node current = head;
        int max = current.data;

        while(current != null){
            if(current.data > max){
                max = current.data;
            }
            current = current.next;
        }
        return max;
}

// Q.11
    int min(){
        if(head == null){
            System.out.println("error in min");
            return -1;
        }
        Node current = head;
        int min = current.data;
        while(current != null){
            if(current.data < min){
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    // Q.12
    int search(int DATA){
        if(this.head==null)
        {
            System.out.println("List is empty");
            return -1;
        }
        int pos = 0;
        Node temp = head;
        while(temp != null){
            if(temp.data == DATA){
                return pos;
            }
            temp = temp.next;
            pos++;
        }
        return -1;
    }

    public static void main(String[] args) {
        singlyLinkedList_Test2 list = new singlyLinkedList_Test2();

        // Q.1 + Q.5 - Testing Insert at front and end
        System.out.println("=== Q.1 + Q.5 - Testing Insert at front and end ===");
        list.Insert(30);
        list.Insert(20);
        list.Insert(10, true);
        list.Insert(40);
        list.display();

        // Q.3 - Delete first
        System.out.println("\n=== Q.3 - Delete first ===");
        list.deleteFirst();
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
        list.reverse();
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
