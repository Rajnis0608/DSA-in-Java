package com.company;

public class LongestCommonSubstring {
    /*
    Substring is continuous part of a string.
    */

    public static int longestCommonSubstringDP(String x,String y,int n,int m){
        int dp[][] = new int[n+1][m+1];
        int result = 0;
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if (x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    result = Math.max(result,dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFDGHR";
        System.out.println(longestCommonSubstringDP(s1,s2,s1.length(),s2.length()));
    }
}
