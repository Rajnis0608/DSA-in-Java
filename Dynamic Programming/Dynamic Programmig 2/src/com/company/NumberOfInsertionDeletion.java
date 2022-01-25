package com.company;

public class NumberOfInsertionDeletion {
    /*
    Given two strings ‘str1’ and ‘str2’ of size n and m respectively. The task is to remove/delete and insert the minimum
    number of characters from/in str1 to transform it into str2. It could be possible that the same character needs to
    be removed/deleted from one point of str1 and inserted to some another point.
    Example:-
    str1 = "heap", str2 = "pea"
    Minimum Deletion = 2 and
    Minimum Insertion = 1
     */
    public static int[] numberofInserionAndDeletion(String x,String y,int m,int n){
        int[] ans= new int[2];
        int dp[][] = new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if (x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        ans[0] = n-dp[m][n];
        ans[1] = m-dp[m][n];
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "heap", str2 = "pea";
        int[] ans = numberofInserionAndDeletion(str1,str2,str1.length(),str2.length());
        System.out.println("Inserions : " + ans[0] + " Deletion : " + ans[1]);
    }
}
