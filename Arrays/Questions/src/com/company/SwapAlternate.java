package com.company;

public class SwapAlternate {
    public static void main(String[] args) {
        int arr[] = {5,9,78,45,3,67};
        for (int i = 0;i < arr.length-1;i=i+2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

        for (int j = 0;j < arr.length;j++){
            System.out.print(arr[j] + " ");
        }
    }
}
