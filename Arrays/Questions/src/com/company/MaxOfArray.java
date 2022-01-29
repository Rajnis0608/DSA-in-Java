package com.company;

public class MaxOfArray {


    public static void main(String[] args) {

        int[] arr = {5,6,7,8,9};
        int max = Integer.MIN_VALUE;
        for (int i = 0;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("Maximum : " + max);
    }
}
