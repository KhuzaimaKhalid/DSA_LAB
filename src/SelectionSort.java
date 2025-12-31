

public class SelectionSort{

//    public void selectionsort(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length ; j++) {
//                int min=i;
//                if(arr[j]<arr[min]){
//                    min=j;
//                }
//                int temp=arr[min];
//                arr[min]=arr[i];
//                arr[i]=temp;
//
//            }
//
//        }
//
//    }
    public static void selectionsort(int[] arr,int index){
        if(index== arr.length-1){
            return;
        }
        int min=index;

        for (int i = index+1; i < arr.length; i++) {
            if(arr[i]<arr[min]){
                min =i;
            }
        }

        int temp=arr[min];
        arr[min]=arr[index];
        arr[index]=temp;

        selectionsort(arr,index+1);

    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        selectionsort(arr, 0);
        for (int i = 0; i < arr.length-1 ; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
