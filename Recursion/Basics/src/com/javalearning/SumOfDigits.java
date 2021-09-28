package com.javalearning;

public class SumOfDigits {
    public static int sumofDigits(int x){
        if(x <= 9){
            return x;
        }
        int smallAns = sumofDigits(x/10);
        return smallAns + x%10;
    }

    public static void main(String[] args) {
        int x = 9;
        System.out.println(sumofDigits(x));
    }
}
