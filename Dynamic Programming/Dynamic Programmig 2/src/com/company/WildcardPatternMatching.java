package com.company;

public class WildcardPatternMatching {

    public static boolean wildCardPattern(String text,String pattern,int m,int n){

        if (m == 0 && n == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        if (m == 0){
            if (pattern.charAt(n-1) == '*')
                return wildCardPattern(text,pattern,0,n-1);
            else
                return false;
        }
        if (text.charAt(m-1) == pattern.charAt(n-1)){
            return wildCardPattern(text,pattern,m-1,n-1);
        }
        if (pattern.charAt(n-1) == '?'){
            return wildCardPattern(text,pattern,m-1,n-1);
        }
        if (pattern.charAt(n-1) == '*'){
            return wildCardPattern(text,pattern,m-1,n) || wildCardPattern(text,pattern,m,n-1);
        }
        return false;
    }

    public static boolean wildCardPatternDP(String text,String pattern,int m,int n){
        boolean dp[][] = new boolean[m+1][n+1];
        for (int i=0;i<=m;i++){
            for (int j = 0;j<=n;j++){
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if(j == 0){
                    dp[i][j] = false;
                }
                else if (i == 0 ){
                    if (pattern.charAt(j-1) == '*'){
                        dp[i][j] = dp[i][j-1];
                    }else {
                        dp[i][j] = false;
                    }
                }
                else if(text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text = "baaabab";
        String pattern1 = "*****ba*****ab"; //output : true
        String pattern2= "baaa?ab"; // output : true
        String pattern3 = "ba*a?"; //output : true
        String pattern4 = "a*ab"; //output : false
        System.out.println(wildCardPattern(text,pattern1,text.length(),pattern1.length()));
        System.out.println(wildCardPattern(text,pattern2,text.length(),pattern2.length()));
        System.out.println(wildCardPattern(text,pattern3,text.length(),pattern3.length()));
        System.out.println(wildCardPattern(text,pattern4,text.length(),pattern4.length()));
        System.out.println(wildCardPatternDP(text,pattern1,text.length(),pattern1.length()));
        System.out.println(wildCardPatternDP(text,pattern2,text.length(),pattern2.length()));
        System.out.println(wildCardPatternDP(text,pattern3,text.length(),pattern3.length()));
        System.out.println(wildCardPatternDP(text,pattern4,text.length(),pattern4.length()));
    }
}
