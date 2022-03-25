package com.javalearning;

import java.util.*;

public class Main {

    public static List<Integer> solve(int X, List<Integer> arr,List<Integer> query_values) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i < arr.size();i++){
            if(arr.get(i) == X){
                temp.add(i+1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i =0 ;i < query_values.size();i++){
            if (query_values.get(i)-1 < temp.size()){
                ans.add(temp.get(query_values.get(i)-1));
            }else {
                ans.add(-1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(9);
        x.add(8);
        x.add(9);
        x.add(9);
        ArrayList<Integer> y = new ArrayList<>();
        y.add(7);
        y.add(3);
        y.add(7);
        y.add(6);
        System.out.println(solve(8,x,y));

    }
}
