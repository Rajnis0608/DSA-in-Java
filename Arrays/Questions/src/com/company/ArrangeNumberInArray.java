package com.company;

import java.util.Scanner;

public class ArrangeNumberInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i = 0,j = n-1;
        for (int k = 1;k <= n;k++){
            if(k % 2 == 0){
                arr[j] = k;
                j--;
            }else {
                arr[i] = k;
                i++;
            }
        }
        for (int k = 0;k < arr.length;k++){
            System.out.print(arr[k] + " ");
        }
    }
}
