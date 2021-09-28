package com.javalearning;

import java.util.Scanner;

public class XPowerN {
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        int smallAns = power(x,n-1);
        return smallAns*x;
     }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of X and N : ");
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(x + " power " + n + " is : " + power(x,n) );
    }
}
