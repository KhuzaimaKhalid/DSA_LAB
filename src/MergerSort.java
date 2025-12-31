

import java.util.Arrays;

public class MergerSort {
//    public static int[] mergeSort(int[] arr){
//        if(arr.length<2){
//            return arr;
//        }
//        int mid = arr.length/2;
//        int[] left = Arrays.copyOfRange(arr,0,mid);
//        int[] right= Arrays.copyOfRange(arr,mid,arr.length);
//        return merge(mergeSort(left),mergeSort(right));
//    }
//    public static int[] merge(int[] left,int[] right){
//        int[] result= new int[left.length+ right.length];
//        int i=0,j=0,k=0;
//        while(i<left.length && j< right.length){
//            if(left[i]<=right[j]){
//                result[k++]=left[i++];
//            } else if (right[j]<= left[i]) {
//                result[k++]=right[j++];
//            }
//        }
//        while(i< left.length){
//            result[k++]=left[i++];
//        }
//        while(j< right.length){
//            result[k++]=right[j++];
//        }
//        return result;
//    }

    public static int[] mergeSort(int[] arr){
        if(arr.length<2){
            return arr;
        }
        int mid = arr.length/2;
        int[] left= Arrays.copyOfRange(arr,0,mid);
        int[] right=Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }
    public static int[] merge(int[] left,int[] right){
        int[] result= new int[left.length+ right.length];
        int i=0,j=0,k=0;
        while(i< left.length && j< right.length){
            if(left[i]<=right[j]){
                result[k++]=left[i++];
            }else if(right[j]<=left[i]){
                result[k++]=right[j++];
            }
        }
        while(i< left.length){
            result[k++]=left[i++];
        }
        while(j< right.length){
            result[k++]=right[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        arr=mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
