package com.company;

public class LongestCommonSubsequence {
    /*
        Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that
        appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, ..
        etc are subsequences of “abcdefg”.
        Example 1 : LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
        Example 2 : LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
    */
    public static int LCS(String x,String y,int n,int m){
        if (n == 0 || m == 0){
            return 0;
        }
        if (x.charAt(n-1) == y.charAt(m-1)){
            return 1+LCS(x,y,n-1,m-1);
        } else {
            return Math.max(LCS(x,y,n-1,m),LCS(x,y,n,m-1));
        }
    }

    public static int LCSM(String x,String y,int n,int m){
        int dp[][] = new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                dp[i][j] = -1;
            }
        }
        return LCSM(x,y,n,m,dp);
    }

    public static int LCSM(String x,String y,int n,int m,int[][] dp){
        if (n == 0 || m == 0){
            dp[n][m] = 0;
            return dp[n][m];
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (x.charAt(n-1) == y.charAt(m-1)){
            dp[n][m] = 1+LCSM(x,y,n-1,m-1);
            return dp[n][m];
        } else {
           dp[n][m] = Math.max(LCSM(x,y,n-1,m),LCSM(x,y,n,m-1));
            return dp[n][m];
        }
    }

   public static int LCSDP(String x,String y,int n,int m){
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
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(LCS(s1,s2,s1.length(),s2.length()));
        System.out.println(LCSM(s1,s2,s1.length(),s2.length()));
        System.out.println(LCSDP(s1,s2,s1.length(),s2.length()));
    }
}
