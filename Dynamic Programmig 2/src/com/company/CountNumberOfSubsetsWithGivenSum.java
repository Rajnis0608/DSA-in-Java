package com.company;

public class CountNumberOfSubsetsWithGivenSum {
    /*
    In this problem you are given an array and a sum value you have to count number of subset present such that
    sum of elements of that subset is equal to given sum value
     Example1 : arr = {2,3,7,8,10}
                sum = 10
                Ans = 3 ({2,8}{10}{3,7})
     Example2 : arr = {2,3,6,4,9,8,7,5}
                sum = 11
                Ans = 6({6,5}{3,8}{2,3,6}{2,4,5}{2,9}{7,4})
    */

    public static int countNumberOfSubsetSum(int[] arr,int sum,int n){
        if(sum == 0){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(arr[n-1] <= sum){
            return countNumberOfSubsetSum(arr,sum-arr[n-1],n-1) + countNumberOfSubsetSum(arr,sum,n-1);
        }else {
            return countNumberOfSubsetSum(arr,sum,n-1);
        }
    }

    public static int countNumberOfSubsetSumDP(int[] arr,int sum,int n){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0 ;i<= n ;i++){
            for(int j=0;j<=sum;j++){
                if(j==0){
                    dp[i][j] = 1;
                }else if (i == 0){
                    dp[i][j] = 0;
                }else if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,7,8,10};
        int sum1 = 10;
        System.out.println(countNumberOfSubsetSum(arr1,sum1,arr1.length));
        System.out.println(countNumberOfSubsetSumDP(arr1,sum1,arr1.length));
        int[] arr2 = {2,3,6,4,9,8,7,5};
        int sum2 = 11;
        System.out.println(countNumberOfSubsetSum(arr2,sum2,arr2.length));
        System.out.println(countNumberOfSubsetSumDP(arr2,sum2,arr2.length));
    }
}
