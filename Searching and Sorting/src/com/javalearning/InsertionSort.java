package com.javalearning;

public class InsertionSort {
    public static void insertionSort(int[] input) {
        for (int i=1; i<input.length ; i++) {
            int j = i-1;
            int temp = input[i];
            while (j >= 0 && input[j] > temp){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = temp;
        }
    }
}
