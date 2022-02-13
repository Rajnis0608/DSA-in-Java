package com.company;

public class MatrixChainMultiplication {
    /*
    Given a sequence of matrices, find the most efficient way to multiply these matrices together.
    The efficient way is the one that involves the least number of multiplications.
    The dimensions of the matrices are given in an array arr[] of size N
    (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).
     */

    static int solve(int arr[],int i,int j,int[][] dp){
        if(i >= j){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int tempAns = solve(arr,i,k,dp) + solve(arr,k+1,j,dp) + (arr[i-1] * arr[k] * arr[j]);
            if (tempAns < ans){
                ans = tempAns;
            }
        }
        return dp[i][j] = ans;
    }

    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N+1][N+1];
        for (int i = 0;i <= N;i++){
            for (int j = 0;j <= N;j++){
                dp[i][j] = -1;
            }
        }

        return solve(arr,1,N-1,dp);
    }

    public static void main(String[] args) {
        int N = 5;
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(matrixMultiplication(N,arr));
    }
}
