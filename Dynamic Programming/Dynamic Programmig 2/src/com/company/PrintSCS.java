package com.company;

public class PrintSCS {
    /*
    Given two strings str1 and str2, the task is to printf the shortest string that has
    both str1 and str2 as subsequences.
    Example:-
    S1 = AGGTAB
    S2 = GXTXAYB
    Ans = AGGXTXAYB
     */
    public static void printSCS(String x,String y,int m,int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = m,j = n;
        String s = "";
        while (i > 0 && j > 0){
            if (x.charAt(i-1) == y.charAt(j-1)){
                s = x.charAt(i-1) + s;
                i--;
                j--;
            } else {
                if (dp[i][j-1] < dp[i-1][j]){
                    s = x.charAt(i-1) + s;
                    i--;
                }else {
                    s = y.charAt(j-1) + s;
                    j--;
                }
            }
        }

        while (i > 0){
            s = x.charAt(i-1) + s;
            i--;
        }

        while (j > 0){
            s = x.charAt(j-1) + s;
            j--;
        }

        System.out.println(s);
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        printSCS(s1,s2,s1.length(),s2.length());
    }
}
