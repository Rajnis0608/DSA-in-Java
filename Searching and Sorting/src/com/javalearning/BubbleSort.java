package com.javalearning;

public class BubbleSort {
    public static void bubbleSort(int[] input) {
        int swaps = 0;
        for (int i=0 ; i<input.length-1 ; i++) {
            for (int j=0 ; j<input.length-1-i ; j++) {
                if(input[j] > input[j+1]) {
                    swaps++;
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
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
        bubbleSort(arr1);
        print(arr1);
        bubbleSort(arr2);
        print(arr2);
        bubbleSort(arr3);
        print(arr3);
        bubbleSort(arr4);
        print(arr4);
    }
}
