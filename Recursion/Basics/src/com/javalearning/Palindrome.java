package com.javalearning;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        boolean smallAns = isPalindrome(str.substring(1, str.length() - 1));
        return smallAns;
    }
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(isPalindrome(s));
    }
}
