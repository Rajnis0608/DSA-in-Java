package com.javalearning;

import java.util.ArrayList;

public class InterpolationSearch {
    public static ArrayList<Integer> interpolationSearch(int[] arr,int lo,int hi,int x,int count){
        int pos = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        if(lo <= hi && x >=arr[lo] && x <= arr[hi]){
            pos = lo + (x-arr[lo])*(hi - lo)/(arr[hi] - arr[lo]);
        }
        if(arr[pos] == x){
          ans.add(pos);
          ans.add(count);
          return ans;
        }
        if (arr[pos] < x){
            return interpolationSearch(arr,pos+1,hi,x,count+1);
        }
        if (arr[pos] > x){
            return interpolationSearch(arr,lo,pos+1,x,count+1);
        }
        ans.add(-1);
        ans.add(count);
        return ans;
    }

    public static ArrayList<Integer> interpolationSearch(int arr[],int x){
        return interpolationSearch(arr,0,arr.length-1,x,1);
    }

    public static void print(ArrayList<Integer> arr){
        System.out.println("Position : " + arr.get(0) + " Iterations : " + arr.get(1));
    }

    public static void main(String[] args) {
        int arr1[] = {1,3,5,7,9,11,13,15,17};
        int arr2[] = {5,10,16,25,29,31,45,51,63};
        int arr3[] = {10,222,9937,100000,3256432,53245321};
        print(interpolationSearch(arr1,5));
        print(interpolationSearch(arr2,16));
        print(interpolationSearch(arr3,100000));
    }

}
