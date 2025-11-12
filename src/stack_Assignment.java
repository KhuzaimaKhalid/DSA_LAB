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
        return this.arr[this.top++];
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


}
