package com.company;

public class SubsetSum {
    /*
    In this problem you are given an array and a sum value you have to check if a subset present such that
    sum of elements of that subset is equal to given sum value
     Example1 : arr = {2,3,7,8,10}
                  sum = 11
                  Ans = true ({3,8})
     Example2 : arr = {3,6,4,9}
                sum = 14
                Ans = false
    */
    public static boolean subsetSum(int[] arr,int sum,int n){
        if (sum == 0){
            return true;
        }
        if (n == 0){
            return false;
        }
        if (arr[n-1] <= sum){
            return subsetSum(arr,sum-arr[n-1],n-1) || subsetSum(arr,sum,n-1);
        }else {
            return subsetSum(arr,sum,n-1);
        }
    }

    public static boolean subsetSumDP(int[] arr,int sum,int n){
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j == 0) {
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }
                else if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 7, 8, 10};
        int sum1 = 11;

        int[] arr2 = {3, 6, 4, 9};
        int sum2 = 14;

        System.out.println(subsetSum(arr1,sum1,arr1.length));
        System.out.println(subsetSum(arr2,sum2,arr2.length));
        System.out.println(subsetSumDP(arr1,sum1,arr1.length));
        System.out.println(subsetSumDP(arr2,sum2,arr2.length));
    }
}
