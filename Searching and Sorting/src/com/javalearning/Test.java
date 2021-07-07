package com.javalearning;

public class Test {

    public static void inc(int arr[]) {
         arr = new int[3]; // 0 0 0
        for(int j=0;j<arr.length;j++){
         arr[j]++;
        }
        for(int j=0;j<arr.length;j++){ //
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr;
        arr = new int[3];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 4;
        for(int j=0;j<arr.length;j++){ // 2 3 4
            System.out.print(arr[j] + " ");
        }
        System.out.println();

        inc(arr);

        for(int j=0;j<arr.length;j++){ // 3 4 5
            System.out.print(arr[j] + " ");
        }
    }
}
