public class singlyLinkedList_Test_claude {
    private Node head;
    int size;

    public singlyLinkedList_Test_claude() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Q.2
    int count(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    // Q.3
    void deleteByValue(int value){
        if(head == null){
            System.out.println("error in deleteByValue");
            return;
        }
        if(head.data == value){
            head = head.next;
            System.out.println("Deleted first occurrence of " + value);
            return;
        }
        Node temp = head;
        while(temp.next != null && temp.next.data != value){
            temp = temp.next;
        }
        if(temp.next == null){
            System.out.println("Value " + value + " not found in list");
            return;
        }
        temp.next = temp.next.next;
    }
// Q.6
    void middle(){
        if(head == null){
            System.out.println("error in middle");
            return;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data);
    }

    // Q.7
    void deleteAllOccurrences(int value){
        if(head == null){
            System.out.println("error in deleteAllOccurrences");
            return;
        }
        if(head.next != null && head.data == value){
            head = head.next;
        }

        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == value){
                temp.next = temp.next.next;
            } else{
                temp = temp.next;
            }
        }
    }

    // Q.8
    void sort(){
        Node current;
        boolean swapped;
        Node last = null;

        do{
            swapped = false;
            current = head;
            while(current.next != last){
                if(current.data > current.next.data){
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        }while(swapped);

    }

    // Q.9
    boolean detectLoop(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // Q.10
    void removeDuplicate(){
        Node current = head;
        while(current != null){
            Node runner = current;
            if(runner.next.data == current.data){
                runner.next = runner.next.next;
            } else{
                runner = runner.next;
            }
            current = current.next;
        }
    }

    // Q.11
    void findNthNodeFromEnd(int n){
        Node first = head;
        Node second = head;
        for (int i = 0; i < n; i++) {
            if(first == null){
                System.out.println("error in  findNthNodeFromEnd");
                return;
            }
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
    }

    public static void main(String[] args) {

    }
}
