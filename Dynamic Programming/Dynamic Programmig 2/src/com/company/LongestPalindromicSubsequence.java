package com.company;

public class LongestPalindromicSubsequence {
    /*
    Given a sequence, find the length of the longest palindromic subsequence in it.
    Example : a = agbcba
    output : 5 (abcba)
     */
    public static int LPS(String x, int n){
        StringBuilder y = new StringBuilder(x);
        y.reverse();
        int m = x.length();

        int dp[][] = new int[n+1][m+1];

        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if (x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }


    public static void main(String[] args) {
        String s = "agbcba";
        System.out.println(LPS(s,s.length()));
    }
}
