package com.javalearning;

import java.util.Scanner;

public class PrintNumbers {
    public static void print(int n){
        if(n == 0){
            return;
        }
        print(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number : ");
        int x = scanner.nextInt();
        print(x);
    }
}
