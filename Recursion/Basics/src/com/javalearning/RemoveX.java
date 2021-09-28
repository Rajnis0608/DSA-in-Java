package com.javalearning;

public class RemoveX {

    public static String removeX(String s) {
        if(s.length() == 0){
            return "";
        }
        if(s.length() == 1) {
            if (s.charAt(0) == 'x') {
                return "";
            }
            else
                return s;
        }
        String smallAns = removeX(s.substring(1));

        if(s.charAt(0) == 'x')
                return smallAns;

            return s.charAt(0) + smallAns;

    }

    public static void main(String[] args) {
        String s = "axbxcx";
        System.out.println(removeX(s));
    }
}
