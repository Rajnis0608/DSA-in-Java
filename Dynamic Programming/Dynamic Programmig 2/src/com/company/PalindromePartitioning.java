package com.company;

public class PalindromePartitioning {
    /*
    Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
    For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for a palindrome
    partitioning of a given string.
    */
    private static boolean isPalindrome(String s,int i,int j){
            while(i < j)
            {
                if(s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
    }

    //Optimized
    private static int solveO(String s,int i,int j,int[][] dp){
        if (i >= j)
            return dp[i][j] =  0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (isPalindrome(s,i,j))
            return dp[i][j] = 0;

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++){
            int left = 0;
            int right = 0;

            if(dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                dp[i][k] = solveO(s, i, k, dp);
                left = dp[i][k];
            }
            if(dp[k+1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                dp[k+1][j] = solveO(s, k + 1, j, dp);
                right = dp[k + 1][j];
            }
            int temp = left + right + 1;
            ans = Math.min(ans,temp);
        }
        return dp[i][j] = ans;
    }


    private static int solve(String s,int i,int j,int[][] dp){
        if (i >= j)
            return dp[i][j] =  0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (isPalindrome(s,i,j))
            return dp[i][j] = 0;

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++){
            int temp = solve(s,i,k,dp) + solve(s,k+1,j,dp) + 1;
            ans = Math.min(ans,temp);
        }
        return dp[i][j] = ans;
    }

    public static int  palindromicPartition(String str){
        int n = str.length();
        int dp[][] = new int[n+1][n+1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= n;j++){
                dp[i][j] = -1;
            }
        }
        return solveO(str,0,str.length()-1,dp);

    }

    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(palindromicPartition(s));
    }
}
