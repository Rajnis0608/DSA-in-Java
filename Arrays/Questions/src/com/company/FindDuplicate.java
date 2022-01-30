package com.company;

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int arr[] = {0,3,1,5,4,3,2};
        Arrays.sort(arr);
        for (int i = 0;i<arr.length;i++){
            if(arr[i] == arr[i+1]) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
