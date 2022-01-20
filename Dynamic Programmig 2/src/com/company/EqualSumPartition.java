package com.company;

public class EqualSumPartition {
    /*
    In this problem you need to identify if you can divide a set into two subsets such that sum of each set is
    equal to each other.
    Example1 : arr = {1,5,11,5}
                  Ans = true ({1,5,5} {11})
     Example2 : arr = {3,6,4,9}
                Ans = false
    */
    public static boolean equalSumPartition(int[] arr,int n){
        int target = 0;
        for (int i=0;i<arr.length;i++){
            target += arr[i];
        }
        if(target % 2 != 0){
            return false;
        }else
            return SubsetSum.subsetSumDP(arr,target/2,n);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};

        int[] arr2 = {3, 6, 4, 9};

        System.out.println(equalSumPartition(arr1,arr1.length));
        System.out.println(equalSumPartition(arr2,arr2.length));
    }
}
