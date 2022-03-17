package com.javalearning;

public class QuickSort {
    static int countSwaps = 0;

    static void swap(int[] arr, int i, int j)
    {
        countSwaps++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {

        int pivot = arr[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                if (i != j)
                    swap(arr,i,j);
            }
        }
        if (i+1 != high)
            swap(arr,i+1,high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

    }

    static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
        System.out.println("Number of swaps: " + countSwaps);
        countSwaps = 0;
    }

    static void print(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr1 = {10,20,30,40,50,60,70,80};
        int[] arr2 = {80,70,60,50,40,30,20,10};
        int[] arr3 = {10,30,50,3,5,7,2,1};
        int[] arr4 = {50,20,60,10,80,90,5,3};
        System.out.println();
        print(arr1);
        quickSort(arr1);
        System.out.println("Sorted Array: ");
        print(arr1);
        System.out.println();

        print(arr2);
        quickSort(arr2);
        System.out.println("Sorted Array: ");
        print(arr2);
        System.out.println();

        print(arr3);
        quickSort(arr3);
        System.out.println("Sorted Array: ");
        print(arr3);
        System.out.println();

        print(arr4);
        quickSort(arr4);
        System.out.println("Sorted Array: ");
        print(arr4);
    }
}
