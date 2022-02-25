package com.javalearning;

public class SelectionSort {
    public static void selectionSort(int[] input) {
        int swaps = 0;
        for(int i=0 ; i<input.length-1 ; i++) { //-1 because total rounds performed are n-1
            int min = input[i];
            int minIndex = i;
            for(int j=i+1 ; j<input.length ; j++) {
                if(input[j] < min){
                    min = input[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                input[minIndex] = input[i];
                input[i] = min;
                swaps++;
            }
        }
        System.out.println("Number od swaps : " + swaps);
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
        selectionSort(arr1);
        print(arr1);
        selectionSort(arr2);
        print(arr2);
        selectionSort(arr3);
        print(arr3);
        selectionSort(arr4);
        print(arr4);

    }

}
