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

    static void print(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr,0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40,50,60,70,80};
        int[] arr2 = {80,70,60,50,40,30,20,10};
        int[] arr3 = {10,30,50,3,5,7,2,1};
        int[] arr4 = {50,20,60,10,80,90,5,3};
        System.out.println();
        print(arr1);
        mergeSort(arr1);
        System.out.println("Sorted Array: ");
        print(arr1);
        System.out.println();

        print(arr2);
        mergeSort(arr2);
        System.out.println("Sorted Array: ");
        print(arr2);
        System.out.println();

        print(arr3);
        mergeSort(arr3);
        System.out.println("Sorted Array: ");
        print(arr3);
        System.out.println();

        print(arr4);
        mergeSort(arr4);
        System.out.println("Sorted Array: ");
        print(arr4);
    }
}
