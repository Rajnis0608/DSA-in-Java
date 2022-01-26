package com.company;

public class MakePalindromic {
    /*
    Given a string of size ‘n’. The task is to remove or delete the minimum number of characters from the string so
    that the resultant string is a palindrome.

    Note: The order of characters should be maintained.
    Example : a = agbcba
    output : 1 (g)
     */
    public static int minimumDeletion(String x, int n){
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
        return n-dp[n][m];
    }

    public static void main(String[] args) {
        String s = "agbcba";
        System.out.println(minimumDeletion(s,s.length()));
    }
}
