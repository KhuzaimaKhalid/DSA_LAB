

public class InsertionSort {
//    public void insertionsort(int[] arr, int size) {
//
//        for (int i = 0; i < size; i++) {
//            int key = arr[i];
//            int j = i - 1;
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j--;
//            }
//            arr[j + 1] = key;
//        }
//
//    }

    public static void insertionsortrec(int[] arr,int size){
        if(size<=1){
            return;
        }
        insertionsortrec(arr,size-1);
        int key=arr[size-1];
        int j=size-2;
        while(j>=0 &&arr[j]>key){
            arr[j+1]=arr[j];
                    j--;
        }
        arr[j+1]=key;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        insertionsortrec(arr, arr.length-1);
        for (int i = 0; i < arr.length-1 ; i++) {
            System.out.print(arr[i]+",");
        }
    }

}

