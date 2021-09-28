package com.javalearning;

public class MergeSort {
    public static void mergeSort(int[] arr,int sI,int eI){
        if(sI >= eI){
            return;
        }
        int mid = (sI+eI)/2;
        mergeSort(arr,sI,mid);
        mergeSort(arr,mid+1,eI);
        merge(arr,sI,eI);
    }

    public static void merge(int[] arr,int sI,int eI){
        int mid = (sI+eI)/2;
        int ans[] = new int[eI - sI +1];
        int i = sI;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= eI){
            if(arr[i] < arr[j]){
                ans[k++] = arr[i++];
            } else {
                ans[k++] = arr[j++];
            }
        }

        while (i <= mid){
            ans[k++] = arr[i++];
        }

        while (j <= eI){
            ans[k++] = arr[j++];
        }

        for (int n = 0; n < ans.length ; n++){
            arr[sI+n] = ans[n];
        }
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr,0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {23,98,76,12,34,66};
        mergeSort(arr);
        for(int i = 0;i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
