public class CircularDoublyLinkedList {
    private Node front,rear;

    public CircularDoublyLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    void insertLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()) {
            front = newNode;
            rear = newNode;
            newNode.next = front;
            newNode.prev = rear;
        } else{
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
            rear.next = front;
            front.prev = rear;
        }
    }
    void max() {
        // System.out.println("hee");
        Node temp = front;
        //System.out.println(temp.data);

        // System.out.println("hee");
        int max = 0;
//        System.out.println(max);
        // System.out.println("hee")
        do {

            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        } while (temp != front);
        System.out.println("max = "+max);
    }
    void display(){
        if(isEmpty()){
            System.out.println("Linked List is Empty");
        }
        Node node = front;
        do{

            System.out.println(" "+node.data);
            node = node.next;

        }while(node != front);
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList c = new CircularDoublyLinkedList();
        c.insertLast(10);
        c.insertLast(20);
        c.insertLast(30);
        c.display();
        c.max();
    }
}
