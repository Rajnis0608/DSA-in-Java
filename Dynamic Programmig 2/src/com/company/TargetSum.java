package com.company;

public class TargetSum {
    /*  STATEMENT 1
    In this problem you have to return number of such solutions possible to achieve given target sum by
    adding sign of + or - in front of array elements and the adding them all

                                               OR

        STATEMENT 2
    In this problem you are given an array and a difference value you have to count number of subset pairs present
    such that difference of sum of their elements is equal to given difference value
     Example1 : arr = {1,1,2,3}
                Difference = 1
                Ans = 3 ({1,1,2}{3};{1,3}{2};{1,3}{2})
    */

    public static int countPairs(int[] arr,int n,int diff){
        int range = 0;
        for (int i=0;i<n;i++){
            range += arr[i];
        }
        int sumOfSubset1 = (range + diff)/2;
        return CountNumberOfSubsetsWithGivenSum.countNumberOfSubsetSumDP(arr,sumOfSubset1,n);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int difference = 1;
        System.out.println(countPairs(arr,arr.length,difference));
    }
}
