package com.company;

import java.util.Arrays;

public class ArrayIntersection {
    public static void main(String[] args) {
        int arr1[] = {2,6,8,5,4,3};
        int arr2[] = {2,3,4,7};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }else if (arr1[i] > arr2[j]){
                j++;
            }else {
                i++;
            }
        }
    }
}
