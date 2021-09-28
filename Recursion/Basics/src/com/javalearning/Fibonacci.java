package com.javalearning;

import java.util.Scanner;

public class Fibonacci {
    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number : ");
        int n = scanner.nextInt();
        System.out.println("Fibonacci number at " + n + " is : " + fib(n));
    }
}
