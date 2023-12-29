import java.util.*;

public class HeapSort {

    static void sort(int[] arr,int index){
        int minIndex = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if(left < arr.length && arr[minIndex] > arr[left]){
            minIndex = left;
        }

        if(right < arr.length && arr[minIndex] > arr[right]){
            minIndex = right;
        }

        if(minIndex != index){
            swap(arr,index,minIndex);
            sort(arr,minIndex);
        }
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {4,3,2,5,1};
//        initial build of min heap from unsorted array
        for(int i = arr.length/2; i >= 0; i--){
            sort(arr,i);
        }
        
        for(int i = arr.length-1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sort(arr,0);
        }
        System.out.println(Arrays.toString(arr));
    }
}
 
