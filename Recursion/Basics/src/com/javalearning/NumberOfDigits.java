package com.javalearning;

import java.util.Scanner;

public class NumberOfDigits {

    public static int countDigits(int n){
        if(n <= 9){
            return 1;
        }
        int smallAns = countDigits(n/10);
        return smallAns + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number : ");
        int n = scanner.nextInt();
        System.out.println("Number of digits in " + n + " are : " + countDigits(n));
    }
}
