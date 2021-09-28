package com.javalearning;

public class Multiplication {
    public static int multiply(int m ,int n){
        if(m== 0 || n == 0){
            return 0;
        }
        if(n == 1){
            return m;
        }
        return m+multiply(m,n-1);
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 0;
        System.out.println(multiply(m,n));
    }
}
