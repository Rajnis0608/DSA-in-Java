package com.company;

import java.util.Arrays;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,3,6,2};
        Arrays.sort(arr);
        for (int i=0;i<arr.length-1;i=i+2){
            if (arr[i] != arr[i+1]){
                System.out.println(arr[i]);
                break;
            }
        }
   }
}
