package com.javalearning;

public class BinarySearch {
    public static int binarySearch(int[] input ,int x) {

        int start = 0;
        int end = input.length-1;

        while (start <= end){
            int mid = (start+end)/2;

            if(input[mid] == x) {
                return mid;
            }
            if(input[mid] >  x) {
                end = mid-1;
            }
            if(input[mid] <  x){
                start = mid+1;
            }
        }
        return -1;
    }
}
