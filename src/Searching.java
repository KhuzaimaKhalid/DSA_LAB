import javax.xml.transform.stax.StAXResult;

public class Searching {
    int[] arr;
    int size;
    int count;

    public Searching(int size) {
        this.size = size;
        this.arr = new int[size];
        this.count = 0;
    }

    public int linearSearch(int data){
        for (int i = 0; i < size; i++) {
            if(arr[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int recursiveLinearSearch(int[] arr, int index, int data){
        if(index == arr.length-1){
            return -1;
        }
        if(arr[index] == data){
            return index;
        }
        return recursiveLinearSearch(arr,index+1,data);
    }

    public int binarySearch(int target){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] < target) {
                low = mid + 1;
            }else if(arr[mid] > target){
                high = mid-1;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public int recursiveBinarySearch(int[] arr, int low, int high, int target){
        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(target < arr[mid]){
            return recursiveBinarySearch(arr,low,mid-1,target);
        } else{
            return recursiveBinarySearch(arr,mid+1,high,target);
        }
    }
    public void insert(int data){
        if(count < size){
            arr[count] = data;
            count++;
        } else {
            System.out.println("Array is full");
        }
    }

    public int evenOdd(int[] arr, int index){
        if(index > arr.length-1){
            return -1;
        }
        if(arr[index] % 2 == 0){
            System.out.println("Even is = "+arr[index]);
        } else{
            System.out.println("Odd is = "+arr[index]);
        }
        return evenOdd(arr,index+1);
    }

    public int sum(int index){
        if(index > arr.length-1){
            return 0;
        }
        return arr[index] + sum(index+1);
    }

    public int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public void printFibonacci(int n){
        for (int i = 0; i < n ; i++) {
            System.out.print(" "+fibonacci(i));
        }
        System.out.println();
    }

    public int sqrt(int x){
        if(x < 2){
            return x;
        }
        int low = 1;
        int high = x/2;
        while(low <= high){
            int mid = (low + high)/2;
            if(mid < x/mid){
                low = mid +1;
            } else if (mid > x/mid){
                high = mid-1;
            } else if (mid == x/mid) {
                return mid;
            }
        }
        return low-1;
    }

    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;

        while(low <= high){
            int mid = (low + high)/2;
            if(mid*mid < num){
                low = mid+1;
            } else if (mid*mid > num) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        boolean found = false;
        while(low <= high){
            int middle = (low+high)/2;
            if(nums[middle] == target){
                found = true;
                return middle;
            } else if(nums[middle] < target){
                low = middle + 1;
            } else{
                high = middle  - 1;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        Searching s = new Searching(5);
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        s.insert(5);
        s.insert(6);
        System.out.println(s.linearSearch(2));
        System.out.println(s.binarySearch(3));
        int[] arr = {2,4,9,11,13};
        System.out.println(s.recursiveBinarySearch(arr,0,arr.length-1, 13));
        System.out.println(s.recursiveLinearSearch(arr,0,11));
        s.evenOdd(arr,0);
        System.out.println(s.sum(0));
        s.printFibonacci(10);
        System.out.println("======================leetcode===============================");
        System.out.println(s.sqrt(4));
        System.out.println(s.sqrt(8));
        System.out.println(s.isPerfectSquare(16));
        System.out.println(s.searchInsert(arr,9));
    }
}
