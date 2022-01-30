package com.company;

import java.util.HashMap;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {1,3,6,2,5,4,3,2,4};
        int target = 7;
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0;i < arr.length;i++){
            if (hm.containsKey(target-arr[i])){
                count = count+hm.get(target-arr[i]);
                if (hm.containsKey(arr[i])){
                    hm.put(arr[i],hm.get(arr[i])+1);
                }else {
                    hm.put(arr[i],1);
                }
            }else {
                if (hm.containsKey(arr[i])){
                    hm.put(arr[i],hm.get(arr[i])+1);
                }else {
                    hm.put(arr[i],1);
                }
            }
        }
        System.out.println(count);
    }
}
