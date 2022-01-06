package com.company;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    static ArrayList<Pair<Integer,Integer>> twoSum(ArrayList<Integer> arr, int target, int n){
        HashMap<Integer,Integer> container = new HashMap<>();
        ArrayList<Pair<Integer,Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(container.get(target-arr.get(i)) != null && !container.get(target-arr.get(i)).equals(0)){
                Pair<Integer,Integer> ele = new Pair<>(arr.get(i),target-arr.get(i));
                ans.add(ele);
                int j = container.get(target-arr.get(i));
                container.put(target-arr.get(i),--j);
            }else {
                if(container.get(arr.get(i)) != null){
                    int j = container.get(arr.get(i));
                    container.put(arr.get(i),++j);
                }else {
                    container.put(arr.get(i), 1);
                }
            }
        }
        if (ans.isEmpty()){
            Pair<Integer,Integer> ele = new Pair<>(-1,-1);
            ans.add(ele);
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int target = sc.nextInt();
            ArrayList<Integer> put = new ArrayList<>();
            for(int j=0;j<n;j++){
                put.add(sc.nextInt());
            }
            System.out.println();
            ArrayList<Pair<Integer,Integer>> ans = twoSum(put,target,n);
            for(int k=0;k<ans.size();k++){
                System.out.println(ans.get(k).first + " " + ans.get(k).second);
            }
        }



    }
}
