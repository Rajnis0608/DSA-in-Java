package com.javalearning;

import java.util.ArrayList;

public class BinarySearch {
    public static ArrayList<Integer> binarySearch(int[] input , int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = input.length-1;
        int count = 0;

        while (start <= end){
            count++;
            int mid = (start+end)/2;

            if(input[mid] == x) {
                ans.add(mid);
                ans.add(count);
                return ans;
            }
            if(input[mid] >  x) {
                end = mid-1;
            }
            if(input[mid] <  x){
                start = mid+1;
            }
        }
        ans.add(-1);
        ans.add(count);
        return ans;
    }

    public static void print(ArrayList<Integer> arr){
        System.out.println("Position : " + arr.get(0) + " Iterations : " + arr.get(1));
    }

    public static void main(String[] args) {
        int arr1[] = {1,3,5,7,9,11,13,15,17};
        int arr2[] = {5,10,16,25,29,31,45,51,63};
        int arr3[] = {10,222,9937,100000,3256432,53245321};
        print(binarySearch(arr1,5));
        print(binarySearch(arr2,16));
        print(binarySearch(arr3,3256432));

    }
}
