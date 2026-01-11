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
    int recursivelinearSearch(int[] arr, int index, int key) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == key) {
            return index;
        }
        return recursivelinearSearch(arr, index + 1, key);
    }

    int binarySearch(int target){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(target < arr[mid]){
                low = mid + 1;
            } else if(target > arr[mid]){
                high = mid - 1;
            } else if (target == arr[mid]){
                return mid;
            }
        }
        return -1;
    }

    int evenOdd(int[] arr, int index){
            if(index > arr.length-1){
                return -1;
            }else if (arr[index] % 2 == 0){
                System.out.println(arr[index] + " is Even");
            }  else {
                System.out.println(arr[index] + " is Even");
            }
        return evenOdd(arr,index+1);
    }

    int recursiveBinarySearch(int[] arr, int low, int high, int target){
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        else if (target < arr[mid]) {
            return recursiveBinarySearch(arr, low, mid - 1, target);
        }
        else {
            return recursiveBinarySearch(arr, mid + 1, high, target);
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
       System.out.println(s.search(2));
       System.out.println(s.binarySearch(3));
        int[] arr = {2,4,9,11,13};
        System.out.println(s.recursiveBinarySearch(arr,0,arr.length-1, 13));
        System.out.println(s.recursivelinearSearch(arr,0,11));
        System.out.println(s.sum(0));
       s.evenOdd(arr,0);
       s.printFibonacci(10);
    }
}
