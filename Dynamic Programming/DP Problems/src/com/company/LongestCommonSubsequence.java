package com.company;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String str1,String str2){
        if (str1.length()==0 || str2.length()==0){
            return 0;
        }
        if(str1.charAt(0) == str2.charAt(0)){
            return 1+longestCommonSubsequence(str1.substring(1),str2.substring(1));
        }else {
            int case1 = longestCommonSubsequence(str1,str2.substring(1));
            int case2 = longestCommonSubsequence(str1.substring(1),str2);
            return Math.max(case1,case2);
        }
    }

    public static int longestCommonSubsequenceM(String str1,String str2){
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            for (int j=0;j<=str2.length();j++){
                dp[i][j] = -1;
            }
        }
        return  longestCommonSubsequenceM(str1,str2,dp);
    }

    private static int longestCommonSubsequenceM(String str1,String str2,int[][] dp){
        int m = str1.length();
        int n = str2.length();
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(m==0 || n==0){
           dp[m][n] = 0;
           return dp[m][n];
        }
        if(str1.charAt(0) == str2.charAt(0)){
            dp[m][n] = 1 + longestCommonSubsequenceM(str1.substring(1),str2.substring(1),dp);
        }else {
            int case1 = longestCommonSubsequenceM(str1,str2.substring(1),dp);
            int case2 = longestCommonSubsequenceM(str1.substring(1),str2,dp);
            dp[m][n] = Math.max(case1,case2);
        }
        return dp[m][n];
    }

    public static int longestCommonSubsequenceDP(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if (i==0 || j==0){
                    dp[i][j] = 0;
                } else {
                    if(str1.charAt(m-i) == str2.charAt(n-j)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
    public static void main(String[] args) {
        String str1 = "dgeigegeigigeigierfghthtcgbdfghthtcg";
        String str2 = "dbeigegeigigeigbgjufgnfghthtcgfghthtcg";
        String s1 = "adef";
        String s2 = "dcaf";
        System.out.println(longestCommonSubsequenceDP(str1,str2));
        System.out.println(longestCommonSubsequenceM(str1,str2));
        System.out.println(longestCommonSubsequence(str1,str2));
    }
}
