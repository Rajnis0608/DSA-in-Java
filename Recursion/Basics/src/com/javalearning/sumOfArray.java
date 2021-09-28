package com.javalearning;

import java.util.Scanner;

public class sumOfArray {
    public static int sum(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }
        int[] smallInput = new int[arr.length - 1];
        for(int i = 1;i < arr.length ; i++){
            smallInput[i-1] = arr[i];
        }
        int smallAns = sum(smallInput);
        return smallAns+arr[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = scanner.nextInt();
        System.out.println("Enter Array elements : ");
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("Sum of array elements is : " + sum(arr));
    }
}
