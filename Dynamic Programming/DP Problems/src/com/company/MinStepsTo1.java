package com.company;

public class MinStepsTo1 {

    //Recursive
    public static int minStepsToOne(int n) {
        if(n == 1){
            return 0;
        }
        int min = minStepsToOne(n-1);
        if(n%3 == 0){
            if (min > minStepsToOne(n/3)){
                min = minStepsToOne(n/3);
            }
        }
        if(n%2 == 0){
            if (min > minStepsToOne(n/2)){
                min = minStepsToOne(n/2);
            }
        }
        return min+1;
    }

    public static int minStepsToOneM(int n){
        int[] storage = new int[n+1];
        for (int i=0;i<=n;i++){
            storage[i] = -1;
        }
        return minStepsToOneM(n,storage);
    }

    private static int minStepsToOneM(int n,int[] storage){
        if (n==1){
            storage[n] = 0;
            return storage[n];
        }
        if(storage[n] != -1){
            return storage[n];
        }
        int min = minStepsToOneM(n-1,storage);
        if(n%3 == 0){
            if (min > minStepsToOneM(n/3,storage)){
                min = minStepsToOneM(n/3,storage);
            }
        }
        if(n%2 == 0){
            if (min > minStepsToOneM(n/2,storage)){
                min = minStepsToOneM(n/2,storage);
            }
        }
        storage[n] = 1+min;
        return storage[n];
    }

    public static int minStepsToOneDP(int n){
        int[] storage = new int[n+1];
        storage[1] = 0;
        for(int i=2;i<=n;i++){
            int min = storage[i-1];
            if(i%3 == 0){
                if(min > storage[i/3]){
                    min = storage[i/3];
                }
            }
            if(i%2 == 0){
                if(min > storage[i/2]){
                    min = storage[i/2];
                }
            }
            storage[i] = min+1;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        int n=1000;
        System.out.println(minStepsToOneDP(n));
        System.out.println(minStepsToOneM(n));
        System.out.println(minStepsToOne(n));
    }
}
