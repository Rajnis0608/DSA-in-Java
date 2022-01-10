package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class PositiveNegativePair {

    public static ArrayList<Integer> findPairs(int arr[], int n) {
        HashMap<Integer,Integer> bucket = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
                if(bucket.get(0-arr[i]) != null && !bucket.get(0-arr[i]).equals(0)){
                    if(arr[i] < 0) {
                        ans.add(arr[i]);
                        ans.add(-arr[i]);
                    }
                    else {
                        ans.add(-arr[i]);
                        ans.add(arr[i]);
                    }
                    int j = bucket.get(0-arr[i]);
                    bucket.put(0-arr[i],--j);
                }else {
                    if(bucket.get(arr[i]) != null){
                        int j = bucket.get(arr[i]);
                        bucket.put(arr[i],++j);
                    }else {
                        bucket.put(arr[i], 1);
                    }
                }
            }
            if (ans.isEmpty()){

                ans.add(0);
            }
            return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int arr[] = {1,3,6,-2,-1,-3,2,7};
        System.out.println(findPairs(arr,n));
    }
}
