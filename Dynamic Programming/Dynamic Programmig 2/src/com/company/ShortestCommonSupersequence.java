package com.company;

public class ShortestCommonSupersequence {
    /*
    Given two strings str1 and str2, the task is to find the length of the shortest string that has
    both str1 and str2 as subsequences.
    Example:-
    S1 = AGGTAB
    S2 = GXTXAYB
    Ans = 9(AGGXTXAYB)
     */
    public static int SCS(String x,String y,int n,int m){
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
        return n+m-dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(SCS(s1,s2,s1.length(),s2.length()));
    }

}
