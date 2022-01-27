package com.company;

public class SequencePatternMatching {
    /*
    Check if a is subsequence of b
    a = "AXY"
    b = "ADXCPY"
     */
    public static boolean sequencePatternMatching(String x,String y,int n,int m){
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
        return dp[n][m] == n;
    }

    public static void main(String[] args) {
        String a = "AXY";
        String b = "ADXCPY";
        System.out.println(sequencePatternMatching(a,b,a.length(),b.length()));
    }
}
