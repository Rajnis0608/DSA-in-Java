package com.company;

public class MinCountOfSquares {

    public static int minCountOfSquaresM(int n){
        int[] storage = new int[n+1];
        for (int i=0;i<=n;i++){
            storage[i] = -1;
        }
        return minCountOfSquaresM(n,storage);
    }

    private static int minCountOfSquaresM(int n,int[] storage){
       if(Math.sqrt(n) == Math.floor(Math.sqrt(n))){
           //perfect square
           storage[n] = 1;
           return storage[n];
       }
       if(n <=3){
           storage[n] = n;
           return storage[n];
       }
       if(storage[n] != -1){
           return storage[n];
       }

       int res = n;
       for (int i=1;i<=n;i++){
           int temp = i*i;
           if (temp > n){
               break;
           }
           else {
               if (storage[n-temp] != -1){
                   res = Math.min(res,1+storage[n-temp]);
               }else {
                   res = Math.min(res, 1 + minCountOfSquaresM(n - temp));

               }
           }
       }
       storage[n] = res;
       return storage[n];
    }
    public static int minCountOfSquares(int n){
        if(Math.sqrt(n) == Math.floor(Math.sqrt(n))){
            //perfect square
            return 1;
        }
        if(n <=3){
            return n;
        }
        int res = n;
        for (int i=1;i<=n;i++){
            int temp = i*i;
            if (temp > n){
                break;
            }
            else {
                res = Math.min(res, 1 + minCountOfSquares(n - temp));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minCountOfSquares(70));
        System.out.println(minCountOfSquaresM(70));

    }
}
