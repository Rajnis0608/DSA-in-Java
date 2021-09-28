package com.javalearning;

public class LastIndexOf {
    private static int find(int[] arr, int n,int end){

        if(arr[arr.length-1] == n){
            return end;
        }
        if(arr.length == 1)
            return -1;
        int[] smallInput = new int[arr.length-1];
        for(int i=0;i < arr.length-1;i++){
            smallInput[i] = arr[i];
        }
        return find(smallInput,n,end-1);
    }

    public static int find(int[] arr, int n){
        return find(arr,n, arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {9,8,10,8};
        int j = 8;

        System.out.println(find(arr,j));
    }
}
