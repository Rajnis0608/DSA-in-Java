package com.javalearning;

public class ReplacePI {
    public static String replacePi(String s) {
        if (s.length() <= 1) {
            return s;
        }
        if (s.charAt(0) == 'p') {
            if (s.charAt(1) == 'i') {
                s = "3.14" + s.substring(2);
            }
        }
        String smallAns = replacePi(s.substring(1));
        return s.substring(0, 1) + smallAns;
    }

    public static void main(String[] args) {
        String s = "xpipix";
        System.out.println(replacePi(s));
    }
}
