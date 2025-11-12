public class stack_Assignment {
private int[] arr;
private int top;

    public stack_Assignment(int size) {
        this.arr = new int[size];
        this.top = -1;
    }

    // Q.2
void push(int data){
        if(this.top == this.arr.length-1){
            System.out.println("error in push");
            return;
        }
        this.arr[++this.top] = data;
}

// Q.3
int pop(){
        if(this.top < 0){
            System.out.println("error in pop");
            return -1;
        }
        return this.arr[this.top--];
}

// Q.4
void peek(){
    if(this.top < 0){
        System.out.println("error in peek");
        return;
    }
    System.out.println(" "+this.arr[this.top]);
}

// Q.5
public boolean isFull(){
    return top == arr.length-1;
}

// Q.6
public boolean isEmpty(){
    return top == -1;
}

// Q.7
int max(){
        int max = this.arr[this.top];
        for(int i = 0; i <= top;i++){
            if(arr[i] > max){
                max = arr[i];
            }

        }
        return max;
}

// Q.8
int min(){
        int min = this.arr[this.top];
    for (int i = 0; i <= top ; i++) {
        if(arr[i] < min){
            min = arr[i];
        }
    }
    return min;
}

// Q.9
 int average(){
        int sum = 0;
     for (int i = 0; i <= top ; i++) {
         sum += arr[i];
     }
     int average = sum/(top+1);
     return average;
 }

 // Q.10
    int search(int value){
        for (int i = 0; i <= top ; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }

 // Q.11
 void evenOdd(){
     for (int i = 0; i <= top ; i++) {
         if(arr[i] % 2 == 0){
             System.out.println("even = "+arr[i]);
         } else{
             System.out.println("odd = "+arr[i]);
         }
     }
 }

 // Q.12
    void reverse(){
        stack_Assignment temp = new stack_Assignment(this.arr.length);
        while(!isEmpty()){
            temp.push(pop());
        }
        print();
        while(!temp.isEmpty()){
            push(temp.pop());
        }
    }
    public void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        stack_Assignment s = new stack_Assignment(5);

        // test push
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        System.out.println("All stack elements:");
        s.print();

        // test peek
        System.out.print("Top element is: ");
        s.peek();

        // test pop
        System.out.println("Popped element: " + s.pop());

        // test isFull and isEmpty
        System.out.println("Is full? " + s.isFull());
        System.out.println("Is empty? " + s.isEmpty());

        // test max, min, average
        System.out.println("Max value: " + s.max());
        System.out.println("Min value: " + s.min());
        System.out.println("Average: " + s.average());

        // test search
        System.out.println("Search 30 found at index: " + s.search(30));

        // test evenOdd
        System.out.println("Even and Odd elements:");
        s.evenOdd();

        // test reverse
        System.out.println("Reversed stack:");
        s.reverse();
    }
}
