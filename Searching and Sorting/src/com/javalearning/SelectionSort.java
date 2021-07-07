package com.javalearning;

public class SelectionSort {
    public static void selectionSort(int[] input) {

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
            }
        }
    }
}
