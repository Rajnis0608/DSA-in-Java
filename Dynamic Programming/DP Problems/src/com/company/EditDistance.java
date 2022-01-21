package com.company;

public class EditDistance {
    /*
    You are given two strings you need to find minimum number of operations to perform
    to make them equal
    OPERATIONS ALLOWED
    Delete
    Substitute
    Add
    */

    public static int editDistance(String str1,String str2){
        if(str1.length() == 0){
            return str2.length();
        }
        if(str2.length() == 0){
            return str1.length();
        }
        if (str1.charAt(0) == str2.charAt(0)){
            return editDistance(str1.substring(1),str2.substring(1));
        }else {
            //Insert
            int opt_1 = editDistance(str1,str2.substring(1));
            //Delete
            int opt_2 = editDistance(str1.substring(1),str2);
            //Substitute
            int opt_3 = editDistance(str1.substring(1),str2.substring(1));
            return 1+Math.min(opt_1,Math.min(opt_2,opt_3));
        }
    }

    public static int editDistanceDP(String str1,String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 0;i<=str1.length();i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(str1.length() - i) == str2.charAt(str2.length() - j)) {
                    /* In case of complete lengths we are comparing 0th elements but i and j reached at end
                    so we compared (length-i)th and (length-j)th elements */
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //Insert
                    int opt_1 = dp[i][j-1];
                    //Delete
                    int opt_2 = dp[i-1][j-1];
                    //Substitute
                    int opt_3 = dp[i-1][j-1];
                    dp[i][j] = 1+Math.min(opt_1,Math.min(opt_2,opt_3));
                }
            }
        }
         return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println(editDistance("adef","gbde"));
        System.out.println(editDistanceDP("adef","gbde"));
    }
}
