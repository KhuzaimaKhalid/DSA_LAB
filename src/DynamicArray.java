class Dynamic_Array {
    char arr[];
    int listSize;

    public Dynamic_Array(char[] arr, int listSize) {
        this.arr = arr;
        this.listSize = listSize;
    }
    public Dynamic_Array() {
        this.arr = new char[5];  // 1 op
        this.listSize = listSize;  // 1 op
    }
//                  Q.2
    public void insert(int index, char c){
        if(index < 0 || index > listSize){   // 3op
            System.out.println("error");  // 1op
            return;  //1op
        }
        if(this.listSize + 1 > this.arr.length){  // 2 op
            System.out.println("Array is full");   // 1 op
            return;   // 1op
        }

        for (int i = this.listSize; i > index ; i--) {  //n
            arr[i] = arr[i-1];  // 3 op
        }
        this.arr[index] = c;  // 2 op
        listSize++;  // 1op
        /*
        3n + 12  = O(n)
         */
    }

    //       Q.3
    public char remove(int index){
        if(index < 0 || index > listSize){   // 1 op
            System.out.println("Error due to invalid input");  // 1op
            return 'x';   // 1 op
        }

        char c = arr[index];  // 1op
        for (int i = index; i < listSize-1; i++) {  // n
            arr[i] = arr[i+1]; // 3 op
        }
        listSize--;    // 1 op
        return c;    // 1 op
        /*
        3n + 6  = O(n)
         */
    }

    //         Q.4
    public char search(char c){
        if(listSize < 0){   // 1 op
            System.out.println("Error due to empty list");   // 1 op
        }
        for (int i = 0; i < listSize; i++) {   // n
            if(arr[i] == c){ // 2 op
                return arr[i]; // 2 op
            }
        }
        System.out.println("element not found"); // 1 op
        return 'x'; // 1 op
        /*
          4n + 4 = O(n)     */
    }

    //         Q.5
    public char max(){
        if(listSize <= 0){   // 2 op
            System.out.println("Error due to empty list");      // 1 op
        }
        char max = arr[0];       // 1 op
        for (int i = 1; i <listSize ; i++) {     // n

            if(arr[i] > max){     // 2 op
                max = arr[i];       // 2 op
            }

        }
        System.out.println(max); // 1 op
        return max;   // 2 op
        /*
        4n + 7 = O(n)
         */
    }

    //        Q.6
    public char min(){
        if(listSize <= 0){   // 1 op
            System.out.println("Error due to empty list");     // 1 op
        }
        char min = arr[0];   // 2 op
        for (int i = 1; i < listSize; i++) {    // n
            if(arr[i] < min){  // 2 op
                min = arr[i];    // 2 op
            }
        }
        System.out.println(min);      // 1 op
        return min;  // 2 op
        /*
        4n + 7  = O(n)
         */
    }
//              Q.7
    public char[] common(char arr2[]){
        char temp[] = new char[listSize];    // 1 op
        int count = 0;   // 1 op
        for (int i = 0; i < arr.length ; i++) {  // n
            for (int j = 0; j < arr2.length; j++) {   // n*n
                if(arr[i] == arr[j]){  // 3 op
                    temp[count] = arr[i];   // 3 op
                    count++;  // 1 op
                    break;  // 1 op
                }
            }
        }
        return temp;    // 1 op
        /*
        8n^2 + n + 3 = O(n^2)
         */
    }

    //          Q.8
    public int product(){
        if(listSize <= 0){      // 1 op
            System.out.println("Error: Empty array");    // 1 op
            return -1; // 1 op
        }
        int product = 1;    // 1 op
        for (int i = 0; i < listSize; i++) {     // n
            product = product * arr[i];  // 4 op
        }
        return product;   // 1 op
        /*
        4n + 5 = O(n)
         */
    }
    //          Q.9
    public int average(){
        if (listSize <= 0) {      // 1 op
            System.out.println("Error due to Empty array");     // 1 op
            return 0;     // 1 op
        }

        int sum = 0;     // 1 op
        for (int i = 0; i < listSize; i++) {       // n
            sum += arr[i];  // 3 op
        }
        int average = sum/listSize; // 3 op
        return average ;  // 2 op
        /*
        3n + 9 = O(n)
         */
    }

    //          Q.11
    public char[] distinct(){
        if(listSize <= 0) {     // 1 op
            System.out.println("Error due to empty list");    // 1 op
            return new char[-1];    // 1 op
        }
        char temp[] = new char[listSize];       // 1 op
        int count = 0;       // 1 op

        for (int i = 0; i < listSize; i++) {         // n
            boolean isDuplicate = false;     // 1 op

            for (int j = 0; j < count; j++) {      // n*n
                if(arr[i] == temp[j]) {      // 3 op
                    isDuplicate = true; // 1 op
                    break;  // 1 op
                }
            }
            if(!isDuplicate) {    // 1 op
                temp[count] = arr[i];   // 3 op
                count++;  //  1 op
            }

        }

        // Return array with only distinct elements
        char result[] = new char[count];   // 1 op
        for (int i = 0; i < count; i++) {   // n
            result[i] = temp[i];   // 3 op
        }

        return result;   // 2 op
        /*
        5n^2 + 6n + 3n + 8 = O(n^2+n)
         */
    }

    //          Q.10
    public char[] reverse(){
        if(listSize <= 0) {   // 1 op
            System.out.println("Error due to empty list");   //  1 op
            return new char[-1];   // 2 op
        }
        char[] reverse = new char[listSize]; // 1 op
        for (int i = 0; i < listSize ; i++) {   // n
            reverse[i] = arr[listSize-1-i];   // 3 op
        }
        return reverse;   // 1 op
        /*
        3n + 5 = O(n)
         */
    }
    //          Q.12
    public char[] replace(char num1, char num2){
        for (int i = 0; i < listSize ; i++) {  // n
            if(arr[i] == num1){   // 1 op
                arr[i] = num2;   // 1 op
            }
        }
        return arr;  // 1 op
        /*
        2n + 1 = O(n)
         */
    }
    //         Q.13
    public void even(){
        for (int i = 0; i < listSize; i++) { // n
            if(arr[i] % 2 == 0){    // 3 op
                System.out.println(" "+arr[i]+" ");  // 1 op
            }
        }
        /*
        4n = O(n)
         */
    }
    //         Q.14
    public void odd(){
        for (int i = 0; i < listSize; i++) {  // n
            if(arr[i] % 2 != 0){  // 3 op
                System.out.println(" "+arr[i]+" ");    // 1 op
            }
        }
        /*
        4n = O(n)
         */
    }
    //      Q.15
    public void prime(){
        for (int i = 0; i < listSize; i++) {   // n
            boolean isPrime = false;  // 1 op
            if(arr[i] <= 1){  // 3 op
                isPrime = false;  // 1 op
            }
            for (int j = 2; j < arr[i] ; j++) {   // n*n
                if(arr[i] % j == 0){  // 3 op
                    isPrime = false;   // 1 op
                    break;   // 1 op
                }
            }

            if(isPrime){     // 1 op
                System.out.println(" "+arr[i]+" ");      // 1 op
            }

        }
        /*
        5n^2 + 7n = O(n^2)
         */
    }
}

public class DynamicArray {
    public static void main(String[] args) {
        char[] initial = {'5', '3', '7', '2', '5', '8', '4'};
        Dynamic_Array da = new Dynamic_Array(initial, 7);

        System.out.println("=== Initial Array ===");
        for (int i = 0; i < 7; i++) {
            System.out.print(initial[i] + " ");
        }
        System.out.println("\n");

                 // Q.2
        System.out.println("=== Q.2 Insert '9' at index 2 ===");
        da.insert(2, '9');

                // Q.4
        System.out.println("\n=== Q.4 Search for '7' ===");
        char found = da.search('7');
        System.out.println("Found: " + found);

             // Q.5
        System.out.println("\n=== Q.5 Maximum ===");
        char maximum = da.max();

                // Q.6
        System.out.println("\n=== Q.6 Minimum ===");
        char minimum = da.min();

                // Q.7
        System.out.println("\n=== Q.7 Common Elements ===");
        char[] arr2 = {'5', '8', '1', '3'};
        char[] commonElements = da.common(arr2);
        System.out.print("Common: ");
        for (int i = 0; i < commonElements.length; i++) {
            if(commonElements[i] != '\0') {
                System.out.print(commonElements[i] + " ");
            }
        }
        System.out.println();

                // Q.8
        System.out.println("\n=== Q.8 Product ===");
        int product = da.product();
        System.out.println("Product: " + product);

                // Q.9
        System.out.println("\n=== Q.9 Average ===");
        int avg = da.average();
        System.out.println("Average: " + avg);

                // Q.10
        System.out.println("\n=== Q.10 Reverse ===");
        char[] reversed = da.reverse();
        System.out.print("Reversed: ");
        for (int i = 0; i < reversed.length; i++) {
            System.out.print(reversed[i] + " ");
        }
        System.out.println();

             // Q.11
        System.out.println("\n=== Q.11 Distinct ===");
        char[] distinct = da.distinct();
        System.out.print("Distinct: ");
        for (int i = 0; i < distinct.length; i++) {
            System.out.print(distinct[i] + " ");
        }
        System.out.println();

                // Q.12
        System.out.println("\n=== Q.12 Replace '5' with '1' ===");
        char[] replaced = da.replace('5', '1');
        System.out.print("After Replace: ");
        for (int i = 0; i < replaced.length; i++) {
            if(replaced[i] != '\0') {
                System.out.print(replaced[i] + " ");
            }
        }
        System.out.println();

                // Q.13
        System.out.println("\n=== Q.13 Even Numbers ===");
        da.even();

                 // Q.14
        System.out.println("\n=== Q.14 Odd Numbers ===");
        da.odd();

                // Q.15
        System.out.println("\n=== Q.15 Prime Numbers ===");
        da.prime();

                // Q.3
        System.out.println("\n=== Q.3 Remove at index 1 ===");
        char removed = da.remove(1);
        System.out.println("Removed: " + removed);
    }
}
