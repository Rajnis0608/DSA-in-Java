package com.javalearning;

public class FirstIndexOf {
    private static int find(int[] arr, int n,int start){

        if(arr[0] == n){
            return start;
        }
        if(arr.length == 1)
            return -1;
        int[] smallInput = new int[arr.length-1];
        for(int i=1;i < arr.length;i++){
            smallInput[i-1] = arr[i];
        }
        return find(smallInput,n,start+1);
    }

    public static int find(int[] arr, int n){
        return find(arr,n,0);
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,1,8};
        int j = 1;
        
        System.out.println(find(arr,j));
    }
}
