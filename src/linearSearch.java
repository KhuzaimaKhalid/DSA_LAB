public class linearSearch {
    int[] arr;
       int size;
       int count = 0;
    public linearSearch(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    int search(int data){

        for (int i = 0; i < arr.length; i++) {
            if(data == arr[i]){
                return i;
            }
        }
        return -1;
    }

    void insert(int data) {
        if (count < size) {
            arr[count] = data;
            count++;
        } else {
            System.out.println("Array is full.");
        }
    }

    int binarySearch(int target){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(target < arr[mid]){
                low = mid - 1;
            } else if(target > arr[mid]){
                high = mid + 1;
            } else if (target == arr[mid]){
                return mid;
            }
        }
        return -1;
    }

    int evenOdd(int[] arr, int data){

            if(data > arr.length-1){
                return -1;
            }else if (arr[data] % 2 == 0){
            return arr[data];
        }  else {
                return evenOdd(arr,data+1);
            }


    }
    int sum(int index) {
        // Base case: reached end of array
        if (index >= arr.length) {
            return 0;
        }

        // Return current element + sum of remaining elements
        return arr[index] + sum(index + 1);
    }

    // Wrapper method to start from index 0
    int sum() {
        return sum(0);
    }

    // Fibonacci using recursion
    int fibonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Recursive case: fib(n) = fib(n-1) + fib(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Print Fibonacci series up to n terms
    void printFibonacci(int n) {
        System.out.print("Fibonacci series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }


//int evenOdd(int[] arr, int target, )

    public static void main(String[] args) {
        
        linearSearch s = new linearSearch(5);
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        s.insert(5);
//        System.out.println(s.search(2));
//        System.out.println(s.binarySearch(3));
        int[] arr = {2,4,9,11,13};
//        System.out.println(s.recursiveBinarySearch(arr,13,0, arr.length-1));
//        s.sum(0);
        System.out.println(s.evenOdd(arr,0));
        s.printFibonacci(10);
    }
}
