package com.javalearning;

public class HeapSort {

    static int countSwaps = 0;

    public static void heapSort(int arr[])
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            countSwaps++;
            heapify(arr, i, 0);
        }
        System.out.println("Number of swaps : " + countSwaps);
        countSwaps = 0;
    }

    static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            countSwaps++;
            heapify(arr, n, largest);
        }
    }

    static void print(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr1 = {10,20,30,40,50,60,70,80};
        int[] arr2 = {80,70,60,50,40,30,20,10};
        int[] arr3 = {10,30,50,3,5,7,2,1};
        int[] arr4 = {50,20,60,10,80,90,5,3};
        System.out.println();
        print(arr1);
        heapSort(arr1);
        System.out.println("Sorted Array: ");
        print(arr1);
        System.out.println();

        print(arr2);
        heapSort(arr2);
        System.out.println("Sorted Array: ");
        print(arr2);
        System.out.println();

        print(arr3);
        heapSort(arr3);
        System.out.println("Sorted Array: ");
        print(arr3);
        System.out.println();

        print(arr4);
        heapSort(arr4);
        System.out.println("Sorted Array: ");
        print(arr4);
    }
}
