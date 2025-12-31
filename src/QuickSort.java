
import javax.management.MBeanAttributeInfo;

public class QuickSort {
    public static void quickSort(int[] arr,int left ,int right){
        int index= partition(arr,left,right);
        if(left<index-1){
            quickSort(arr,left,index-1);
        }
        if(index<right){
            quickSort(arr,index,right);
        }
    }
    public static int partition(int[] arr,int left,int right){
        int i=left;
        int j=right;
        int temp;
        int pivot= arr[(left+right)/2];
        while(i<=j){
            while(arr[i]<pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<=j){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        quickSort(arr,0, arr.length-1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
