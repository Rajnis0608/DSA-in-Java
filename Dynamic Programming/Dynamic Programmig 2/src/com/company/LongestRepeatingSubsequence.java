package com.company;

public class LongestRepeatingSubsequence {
    /*
    Given a string, find the length of the longest repeating subsequence such that the two subsequences don’t
    have same string character at the same position, i.e., any i’th character in the two subsequences shouldn’t
    have the same index in the original string.
    Example: String = AABEBCDD
    ans = 3(ABD)
     */
    public static int longestRepeatingSubsequence(String x,int n){
        String y = x;
        int m = n;
        int dp[][] = new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if (x.charAt(i-1) == y.charAt(j-1) && i != j){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "AABEBCDD";
        System.out.println(longestRepeatingSubsequence(s,s.length()));
    }
}
