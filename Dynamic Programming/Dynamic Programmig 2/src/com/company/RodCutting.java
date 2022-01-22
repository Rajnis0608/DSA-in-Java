package com.company;

public class RodCutting {
    /*(Just statement variation of unbounded knapsack)
    Given a rod of length N inches and an array of prices that includes prices of all pieces of size smaller
    than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
    N : 8
    price : {1,5,8,9,10,17,17,20}
    length : {1,2,3,4,5,6,7,8}
    output : 22 (length 2 + length 6 (5+17))
    */

    public static int rodCutting(int[] length,int[] price,int N){
            int[][] dp = new int[length.length+1][N+1];
            for (int i=0;i<=length.length;i++){
                for (int j=0;j<=N;j++){
                    if (i==0 || j==0){
                        dp[i][j] = 0;
                    } else if (length[i-1] <= j){
                        dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[length.length][N];
    }

    public static void main(String[] args) {
        int N = 8;
        int[] prices = {1,5,8,9,10,17,17,20};
        int[] length = {1,2,3,4,5,6,7,8};
        System.out.println(rodCutting(length,prices,N));
    }

}
