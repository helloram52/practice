//my implementation of Merge Sort

public class MergeSort {

    static void mergeSort(int[] arr, int start, int end) {

            if(start >= end) {
                return;
            }

            int mid=(start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {

        int[] temp=new int[end-start+1];
        int k=0, i=start, j=mid+1;

        if(start == mid) {
            if(arr[start] > arr[end]) {
                int swap=arr[end];
                arr[end]=arr[start];
                arr[start]=swap;
            }
            return;
        }

       while(i<=mid && j<=end) {

           if(arr[i] < arr[j]) {
               temp[k++]=arr[i++];
           }
           else {
               temp[k++]=arr[j++];
           }
       }

       if(i<=mid) {
           while(i<=mid) {
               temp[k++]=arr[i++];
           }
       }
       else if(j<=end) {
            while(j<=end) {
                temp[k++]=arr[j++];
            }
       }

        k=0;

        for(i=start; i<=end; i++) {
            arr[i] = temp[k++];
        }
    }

    public static void main(String[] args) {

        int[] arr={14, 7, 3, 12, 9, 11, 6, 2};

        mergeSort(arr, 0, arr.length-1);
        for(int val:arr) {
            System.out.print(val+" ");
        }
    }
}
