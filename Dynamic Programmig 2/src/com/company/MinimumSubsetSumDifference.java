package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumSubsetSumDifference {
    /*
    In this problem you are given an array and we have to find minimum possible subset difference if we
    are dividing a array into two susets
     Example1 : arr = {1,6,11,5}
                Ans = 1 ({6,5}{1,11})
    */
    public static int minimumSubsetSumDifference(int[] arr,int n){
        int range = 0;
        for (int i=0;i<n;i++){
            range += arr[i];
        }
        boolean[][] dp = new boolean[n+1][range/2+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=range/2;j++){
                if(j==0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int k=0;k<= range/2;k++ ){
            arrayList.add(k);
        }
        int sumOfSubset1 = Collections.max(arrayList);
        return range-2*sumOfSubset1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,6,11,5};
        System.out.println(minimumSubsetSumDifference(arr1,arr1.length));
    }
}
