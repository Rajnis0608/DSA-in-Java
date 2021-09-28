package com.javalearning;

public class GeometricSum {

    public static double geoSum(int k){
        if(k == 0){
            return 1;
        }
        double smallAns = geoSum(k-1);
        return (smallAns + Math.pow((double) 1/2,(double) k));
    }

    public static void main(String[] args) {
        int k = 4;
        System.out.println(geoSum(k));
    }
}
