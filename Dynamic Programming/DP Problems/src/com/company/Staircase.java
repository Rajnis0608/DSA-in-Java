package com.company;

public class Staircase {
    public static int allPossibleWays(int n){
        int[] ways = new int[n+1];
        for (int i=0;i<=n;i++){
            if (i == 0){
                ways[i] = 0;
            }else if (i == 1){
                ways[i] = 1;
            }else if (i == 2){
                ways[i] = 2;
            }else if (i == 3){
                ways[i] = 3;
            }else {
                ways[i] = 1+ways[i-1]+ways[i-2]+ways[i-3];
            }
        }
        return ways[n];
    }


    public static void main(String[] args) {
        System.out.println(allPossibleWays(5));
    }
}
