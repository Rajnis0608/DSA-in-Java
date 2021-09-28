package com.javalearning;

public class FindX {
    public static boolean find(int[] arr,int x){
        if(arr.length == 1){
            if(arr[0] == x)
                return true;
            return false;
        }
        int[] smallInput = new int[arr.length-1];
        for(int i=1;i < arr.length;i++){
            smallInput[i-1] = arr[i];
        }
        boolean smallAns = find(smallInput,x);
        if(smallAns == true){
            return smallAns;
        }
        return arr[0]==x;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,7,8,3};
        int x = 10;
        System.out.println(find(arr,x));
    }
}
