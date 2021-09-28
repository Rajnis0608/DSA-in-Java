package com.javalearning;

public class CheckSorted {
    public static boolean isSorted(int[] arr){
        if(arr.length <=1)
            return true;
        int[] smallInput = new int[arr.length - 1];
        for(int i = 0; i < arr.length-1 ;i++){
            smallInput[i] = arr[i];
        }
        boolean smallAns = isSorted(smallInput);
        if(!smallAns)
            return false;

        if(arr[arr.length-2] < arr[arr.length-1])
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        if(isSorted(arr))
            System.out.println("ARRAY IS SORTED");
        else
            System.out.println("ARRAY IS NOT SORTED");
    }
}
