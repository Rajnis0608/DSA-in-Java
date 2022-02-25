package com.javalearning;

public class InsertionSort {
    public static void insertionSort(int[] input) {
        int swaps = 0;
        for (int i=1; i<input.length ; i++) {
            int j = i-1;
            int temp = input[i];
            while (j >= 0 && input[j] > temp){
                input[j+1] = input[j];
                j--;
            }

            if(input[j+1] != temp){
                swaps++;
                input[j+1] = temp;
            }

        }
        System.out.println("Number of swaps : " +  swaps);
    }

    public static void print(int[] arr) {
        for(int i =0 ;i< arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40,50,60,70,80};
        int[] arr2 = {80,70,60,50,40,30,20,10};
        int[] arr3 = {10,30,50,3,5,7,2,1};
        int[] arr4 = {50,20,60,10,80,90,5,3};
        insertionSort(arr1);
        print(arr1);
        insertionSort(arr2);
        print(arr2);
        insertionSort(arr3);
        print(arr3);
        insertionSort(arr4);
        print(arr4);

    }
}
