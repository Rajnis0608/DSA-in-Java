package com.company;

public class Knapsack01 {

    private static int knapsack(int[] wt,int[] val,int W,int n){
        if(n == 0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            return Math.max(val[n-1]+knapsack(wt,val,W-wt[n-1],n-1),knapsack(wt,val,W,n-1));
        }else {
            return knapsack(wt,val,W,n-1);
        }
    }

    public static int knapsack(int[] wt,int[] val,int W){
        return knapsack(wt,val,W,wt.length);
    }

    private static int knapsackM(int[] wt,int[] val,int W,int n,int[][] dp){
        if(n==0 || W==0){
            return dp[n][W] = 0;
        }
        if (dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] <= W){
            return dp[n][W] = Math.max(val[n-1]+knapsackM(wt,val,W-wt[n-1],n-1,dp),knapsackM(wt,val,W,n-1,dp));
        }else {
            return dp[n][W] = knapsackM(wt,val,W,n-1,dp);
        }
    }

    public static int knapsackM(int[] wt,int[] val,int W){
        int[][] dp = new int[wt.length+1][W+1];
        for (int i=0;i<=wt.length;i++){
            for (int j=0;j<=W;j++){
                dp[i][j] = -1;
            }
        }
        return knapsackM(wt,val,W,wt.length,dp);
    }

    public static int knapsackDP(int[] wt,int[] val,int W){
        int[][] dp = new int[wt.length+1][W+1];
        for (int i=0;i<=wt.length;i++){
            for (int j=0;j<=W;j++){
                if (i==0 || j==0){
                    dp[i][j] = 0;
                } else if (wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[wt.length][W];
    }

    public static void main(String[] args) {
        int[] wt = {1,3,4,5,8,5,7,9};
        int[] val ={1,4,5,7,8,5,6,7};
        int W = 10;
        System.out.println(knapsack(wt,val,W));
        System.out.println(knapsackM(wt,val,W));
        System.out.println(knapsackDP(wt,val,W));
    }
}
