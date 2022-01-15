package com.company;

public class BalancedBTs {
    //Balanced BTs are those whose difference of left subtree and right subtree is <= 1
    public static int countBalancedBTs(int h){
        int mod = (int)Math.pow(10,9)+7;
        return countBalancedBTs(h,mod);
    }

    public static int countBalancedBTs(int h,int mod){
        if (h==0 || h==1){
            return 1;
        }
        int x = countBalancedBTs(h-1);
        int y = countBalancedBTs(h-2);
        long res1 = (long)x*x;
        long res2 = (long)x*y*2;
        int val1 = (int)(res1%mod);
        int val2 = (int)(res2%mod);
        return (val1+val2)%mod;
    }

    public static void main(String[] args) {
        int h = 7;
        System.out.println(countBalancedBTs(h));
    }
}
