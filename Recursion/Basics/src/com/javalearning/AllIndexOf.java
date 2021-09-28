package com.javalearning;

import java.util.ArrayList;

public class AllIndexOf {
    private static ArrayList<Integer> ans = new ArrayList<>();
    private static ArrayList<Integer> find(int[] arr, int n, int start){

        if(arr[0] == n){
            ans.add(start);
        }
        if(arr.length <= 1)
            return ans;

        int[] smallInput = new int[arr.length-1];
        for(int i=1;i < arr.length;i++){
            smallInput[i-1] = arr[i];
        }
        return find(smallInput,n,start+1);
    }

    public static int[] find(int[] arr, int n) {
        ArrayList<Integer> ans1 = find(arr,n,0);
        int[] ans = new int[ans1.size()];
        int j = 0;
        for(int i = 0; i < ans.length; i++) {
            ans[i] = ans1.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {9,8,10,8,8};
        System.out.println(find(arr,8));

    }
}
