package com.company;

public class CoinChange {
    /*Problem 1 : Number of ways
    Given a value N, if we want to make change for N cents, and we have infinite supply of each of
    S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
    For Example:
   N = 10
   S = {2, 5, 3, 6}
   Ans:5 ({2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5})
    */
    public static int numberOfWays(int[] S,int N){
        int[][] dp = new int[S.length+1][N+1];
        for (int i=0;i<=S.length;i++){
            for (int j=0;j<=N;j++){
                if (j == 0){
                    dp[i][j] = 1;
                }
                else if (i == 0){
                    dp[i][j] = 0;
                }
                else if (S[i-1] <= j){
                    dp[i][j] = dp[i][j-S[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[S.length][N];
    }

    /*
    Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of C = { C1, C2, .., Cm}
    valued coins, what is the minimum number of coins to make the change?
    V = 10
    C = {2, 5, 3, 6}
    Ans:5 ({5,5 })
    */
    public static int minimumNumberOfCoins(int[] S,int N){
         int[][] dp = new int[S.length+1][N+1];
         for (int i=0;i<=S.length;i++){
             for (int j=0;j<=N;j++){
                 if (i == 0){
                     dp[i][j] = Integer.MAX_VALUE -1;
                 }else if (j==0){
                     dp[i][j] = 0;
                 }else if (i == 1){
                     if (j% S[i-1] == 0){
                         dp[i][j] = j/S[i-1];
                     }else {
                         dp[i][j] = Integer.MAX_VALUE -1;
                     }
                 }else if (S[i-1] <= j){
                     dp[i][j] = Math.min(1+dp[i][j-S[i-1]],dp[i-1][j]);
                 }else {
                     dp[i][j] = dp[i-1][j];
                 }
             }
         }
         return dp[S.length][N];
    }

    public static void main(String[] args) {
        int N = 10;
        int[] S = {2, 5, 3, 6};
        System.out.println(numberOfWays(S,N));
        System.out.println(minimumNumberOfCoins(S,N));
    }

}
