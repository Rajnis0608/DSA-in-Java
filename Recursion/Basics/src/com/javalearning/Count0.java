package com.javalearning;

public class Count0 {
    public static int count0(int num){
        if(num <= 9){
            if (num == 0){
                return 1;
            }
            return 0;
        }
        int smallAns = count0(num/10);
        if(num % 10 == 0)
            return smallAns+1;
        return smallAns;
    }

    public static void main(String[] args) {
        int num = 0;
        System.out.println(count0(num));
    }
}
