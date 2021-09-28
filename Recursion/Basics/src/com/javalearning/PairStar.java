package com.javalearning;



public class PairStar {
    public static String pairStar(String s){
        if(s.length() <= 1){
            return s;
        }
        String ans = "";
        if(s.charAt(0) == s.charAt(1)){
            ans = s.charAt(0) + "*";
        }
        else {
            ans = ans + s.charAt(0);
        }
        String smallAns = pairStar(s.substring(1));
        return ans + smallAns;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(pairStar(s));

    }
}
