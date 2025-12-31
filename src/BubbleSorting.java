

public class BubbleSorting {

//    static boolean bubbleSort(int arr[], int n) {
//        int temp;
//        boolean swapped;
//        boolean alreadySorted = true; // assume sorted initially
//
//        for (int i = 0; i < n - 1; i++) {
//            swapped = false;
//
//            for (int j = 0; j < n - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    // swap
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    swapped = true;
//                    alreadySorted = false; // swapping means NOT already sorted
//                }
//            }
//        }
//        return alreadySorted;
//    }
//
//    static void printArray(int arr[], int size) {
//        for (int i = 0; i < size; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }


//    static void bubbleSort (int a[ ] , int size)
//{
//    int i, j, temp;
//    for ( i = 0; i < size; i++ )    /* controls passes through the list */
//    {
//        for ( j = 0; j < size - i-1; j++ )   /* performs adjacent comparisons */
//        {
//            if ( a[ j ] > a[ j+1 ] )   /* determines if a swap should occur */
//            {
//                temp = a[ j ];       /* swap is performed */
//                a[ j ] = a[ j + 1 ];
//                a[ j+1 ] = temp;
//            }
//        }
//    }
//}

    public static int bubblesort(int[] arr, int size){
        if(size<=1){
            return 1;
        }
        for (int j = 0; j < size-1; j++) {
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        return bubblesort(arr,size-1);
    }


    public static void main(String args[]) {
        int[] arr = {5, 1, 4, 2, 8};
        bubblesort(arr, arr.length-1);
        for (int i = 0; i < arr.length-1 ; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
