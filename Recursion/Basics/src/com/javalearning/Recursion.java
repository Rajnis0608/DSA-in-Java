package com.javalearning;

import java.util.Scanner;

public class Recursion {

    public static int fact (int n){
        if(n == 1 || n == 0){
            return 1;
        }
        int smallAns = fact(n-1);
        return n*smallAns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number : ");
        int x = scanner.nextInt();
        System.out.println("Factorial of " + x + " is : " + fact(x));
    }
}
