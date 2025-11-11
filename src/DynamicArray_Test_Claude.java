public class DynamicArray_Test_Claude {
    char[] arr;
    int listSize;

    public DynamicArray_Test_Claude(char[] arr, int listSize) {
        this.arr = arr;
        this.listSize = listSize;
    }
    public DynamicArray_Test_Claude() {
        this.arr = new char[5];
        this.listSize = listSize;
    }


    // Q.2
    char insertFirst(char c){
        this.arr[this.listSize] = c;
        return c;
    }

    // Q.3
    char deleteLast(){
        return this.arr[this.listSize--];
    }

    // Q.4
    int search(char c){
        for (int i = 0; i < listSize; i++) {
            if(arr[i] == c){
                return i;
            }
        }
        return -1;
    }

    // Q.5
    char secondLargest(){
        if(listSize < 2){
            System.out.println("error in secondLargest");
            return 'x';
        }
        char max = '\0';
        char secondMax = '\0';

        for (int i = 0; i < listSize ; i++) {
            if(arr[i] > max){
                max = arr[i];
            } else if(arr[i] > secondMax && arr[i] != max ){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // Q.6
    char secondSmallest(){
        if(listSize < 2){
            System.out.println("error in second smallest");
            return 'x';
        }
        char min = '\0';
        char secondMin = '\0';
        for (int i = 0; i < listSize; i++) {
            if(arr[i] < min){
                min = arr[i];
            } else if (arr[i] < min &&arr[i] != min){
                secondMin = arr[i];
            }
        }
        return secondMin;
    }

    // Q.7
    char[] unique(){
        int[] freq = new int[256];
        for (int i = 0; i < listSize; i++) {
            freq[arr[i]]++;
        }
        char[] temp = new char[listSize];
        int count = 0;
        boolean[] isadded = new boolean[256];

        for (int i = 0; i < listSize ; i++) {
            if(freq[arr[i]] == 1 && !isadded[arr[i]]){
                temp[count] = arr[i];
                count++;
                isadded[arr[i]] = true;
            }
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    // Q.8
    int sum(){
        int sum = 0;
        for (int i = 0; i < listSize; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Q.9
    void frequency(){
        int[] freq = new int[256];
        boolean[] printed = new boolean[256];

        for (int i = 0; i < listSize ; i++) {
            if(!printed[arr[i]]){
                System.out.println(arr[i] + ": " + freq[arr[i]]);
                printed[arr[i]] = true;
            }
        }
    }
// Q.10
    char[] swap(int index1, int index2){
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        return arr;
    }

    public static void main(String[] args) {

    }

}
