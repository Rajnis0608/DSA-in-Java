package com.javalearning;

import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static int sum(int n){
        if(n==1)
            return 1;
        int samllAns = sum(n-1);
        return n+samllAns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number : ");
        int x = scanner.nextInt();
        System.out.println("Sum of " + x + " natural numbers is : " + sum(x) );
    }
}
