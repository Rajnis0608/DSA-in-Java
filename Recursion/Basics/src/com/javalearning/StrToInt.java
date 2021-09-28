package com.javalearning;

public class StrToInt {
    public static int stringToInteger(String s){
        if(s.length() == 1){
            return Integer.valueOf(s);
        }
        int smallAns = stringToInteger(s.substring(0,s.length()-1));
        return smallAns*10+Integer.parseInt(s.substring(s.length()-1,s.length()));
    }

    public static void main(String[] args) {
        String s = "12567";
        int ans = stringToInteger(s);
        System.out.println(ans);
    }
}
