public class circular_linkedlist {
    Node front,rear;
    private class Node{
        int data;
        Node next, prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    boolean isEmpty(){
        return front == null;
    }

    void insertLast(int DATA){
        Node newNode = new Node(DATA);
        if(isEmpty()){
            this.front = newNode;
            this.rear = newNode;
            newNode.next = front;
        } else{
            rear.next = newNode;
            newNode.next = front;
            rear = newNode;
        }
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

    int max(){
        Node temp = front;
        int max = 0;
        do{
           if(temp.data > max){
               max = temp.data;
           }
           temp = temp.next;
        }while(temp != front);
        return max;
    }

    int min(){
        Node temp = front;
        int min = Integer.MAX_VALUE;
        do{
            if(temp.data < min){
                min = temp.data;
            }
            temp = temp.next;
        } while(temp != front);
        return min;
    }

    int sum(){
        Node temp = front;
        int sum = 0;
        do{
           sum = sum + temp.data;
            temp = temp.next;
        } while(temp != front);
        return sum;
    }

    int product(){
        Node temp = front;
        int product = 1;
        do{
            product = product * temp.data;
            temp = temp.next;
        } while(temp != front);
        return product;
    }
    int size(){
        Node temp = front;
        int size = 0;
        do{
            size++;
            temp = temp.next;
        } while(temp != front);
        return size;
    }

    int average(){
        return sum()/size();
    }

    void insertPosition(int DATA, int pos){
        Node temp = front;
        int j = 0;
        while(j < pos-1){
            temp = temp.next;
            j++;
        }
        Node newNode = new Node(DATA);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deletePosition( int pos){
        Node temp = front;
        int j = 0;
        while(j < pos-1){
            temp = temp.next;
            j++;
        }
        temp.next = temp.next.next;
    }

    void deleteLast(){
        Node temp = front;
        while(temp.next != rear){
            temp = temp.next;
        }
        temp.next = front;
        rear = temp;
    }

    public static void main(String[] args) {
        circular_linkedlist c = new circular_linkedlist();
        c.insertLast(10);
        c.insertLast(20);
        c.insertLast(30);
        c.display();
        System.out.println(c.max());
        System.out.println(c.min());
        System.out.println(c.sum());
        System.out.println(c.product());
        System.out.println(c.size());
        System.out.println(c.average());
        System.out.println("===================================================================");
        c.insertPosition(25,2);
        c.display();
        System.out.println("===================================================================");
        c.deletePosition(2);
        c.display();
        System.out.println("===================================================================");
        c.deleteLast();
        c.display();

    }
}
