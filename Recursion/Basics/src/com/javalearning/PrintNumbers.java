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

    public static void print2Mul(int n){
        if(n == 1) {
            return;
        }
        print2Mul(n-1);
        if(n%2 == 0){
            System.out.print(n + " ");
        }
    }

    public static void printNto1(int n){
        if(n == 0 ){
            return;
        }
        System.out.print(n + " ");
        printNto1(n-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number : ");
        int x = scanner.nextInt();
        print(x);
        System.out.println();
        print2Mul(x);
        System.out.println();
        printNto1(x);
    }
}
