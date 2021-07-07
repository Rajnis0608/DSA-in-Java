package com.javalearning;

public class BubbleSort {
    public static void bubbleSort(int[] input) {
        for (int i=0 ; i<input.length-1 ; i++) {
            for (int j=0 ; j<input.length-1-i ; j++) {
                if(input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
    }
}
