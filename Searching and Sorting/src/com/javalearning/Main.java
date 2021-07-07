package com.javalearning;

public class Main {

    public static void main(String[] args) {

        //Sorted array for binary search
        int[] input1 = {2,4,7,9,10,12};
        System.out.println("Index of 4 is " + BinarySearch.binarySearch(input1,4));

        //Selection sort
        int[] input2 = {2,6,9,1,5};
        SelectionSort.selectionSort(input2);
        for(int i=0 ; i<input2.length ; i++){
            System.out.print(input2[i] + " ");
        }
        System.out.println();

        //Bubble sort
        int[] input3 = {8,2,6,1,5};
        BubbleSort.bubbleSort(input3);
        for(int i=0 ; i<input3.length ; i++){
            System.out.print(input3[i] + " ");
        }
        System.out.println();

        //Insertion sort
        int[] input4 = {6,4,3,5,2,1,9};
        InsertionSort.insertionSort(input4);
        for(int i=0 ; i<input4.length ; i++){
            System.out.print(input4[i] + " ");
        }
        System.out.println();
    }
}
