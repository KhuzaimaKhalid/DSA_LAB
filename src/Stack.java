public class Stack {
    private int capacity;
     int[] stackArray;
    private int top;

    public Stack(int size) {
        this.capacity = size;
        this.stackArray = new int[capacity];
        this.top = -1;
    }


    public boolean isFull(){
        return top == capacity-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException("Stack is Full");
        }
        stackArray[++top] = value;
    }
    public int pop(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stackArray[top--];
    }
    public void lastSwap(){
         int a = pop();
         int b = pop();
         push(a);
         push(b);

    }
    public void firstSwap(){


        Stack temp = new Stack(capacity);
        while (!isEmpty()){
            temp.push(pop());
        }
        lastSwap();
        while(!temp.isEmpty()){
            push(temp.pop());
        }



    }
    public void print(){
        for (int i = 0; i < capacity; i++) {
            System.out.println(stackArray[i]+" ");
        }
    }

    public static void main(String[] args) {
        Stack ss = new Stack(4);
        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.print();

//
//        System.out.println("============================================================================");
//        ss.lastSwap();
//        ss.print();
//
//
      System.out.println("============================================================================");
        ss.lastSwap();
        ss.print();

    }
}
