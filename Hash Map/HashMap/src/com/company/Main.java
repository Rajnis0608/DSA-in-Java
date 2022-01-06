package com.company;

import java.util.ArrayList;

public class Main {

    public static int maxOccur(int[] arr) {
        Map<String,Integer> map = new Map<>();
        int max = Integer.MIN_VALUE;
        int ans = arr[0];
        for(int i=0;i<arr.length;i++){
            if(map.getValue(String.valueOf(arr[i])) == null){
                map.insert(String.valueOf(arr[i]),1);
            }
            else {
                int temp = map.getValue(String.valueOf(arr[i]));
                map.insert(String.valueOf(arr[i]), temp++);
                if (max < map.getValue(String.valueOf(arr[i]))) {
                    max = map.getValue(String.valueOf(arr[i]));
                    ans = arr[i];
                }
            }
        }
        return ans;
    }

    private static ArrayList<Pair<Integer,Integer>> pairWithSumZero(int[] arr) {
        ArrayList<Pair<Integer,Integer>> ans = new ArrayList<>();
        Map<String,Integer> map =new Map<>();
        for(int i=0;i<arr.length;i++){
            if(map.getValue(String.valueOf(-arr[i])) == null){
                map.insert(String.valueOf(arr[i]),0);
            }else {
                map.insert(String.valueOf(arr[i]),0);
                Pair<Integer,Integer> pair;
                if(arr[i] < 0){
                    pair = new Pair<>(arr[i],-arr[i]);
                }else {
                    pair = new Pair<>(-arr[i],arr[i]);
                }
                ans.add(pair);
            }
        }
        return ans;
    }

    public static void printPairsWithSumZero(int[] arr){
        ArrayList<Pair<Integer,Integer>> ans = pairWithSumZero(arr);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).key + " " + ans.get(i).value);
        }
    }

    public static ArrayList<Integer> intersection(int[] arr1,int[] arr2){
        ArrayList<Integer> ans = new ArrayList<>();
        Map<String,Integer> map =new Map<>();
        for(int i=0;i<arr1.length;i++){
            if(map.getValue(String.valueOf(arr1[i])) == null){
                map.insert(String.valueOf(arr1[i]),1);
            }else {
                int temp = map.getValue(String.valueOf(arr1[i]));
                map.insert(String.valueOf(arr1[i]), ++temp);
            }
        }
        for (int j=0;j<arr2.length;j++){
            if(map.getValue(String.valueOf(arr2[j])) != null){
                ans.add(arr2[j]);
                int temp = map.getValue(String.valueOf(arr2[j]));
                temp--;
                if(temp==0){
                    map.removeKey(String.valueOf(arr2[j]));
                }else {
                    map.insert(String.valueOf(arr2[j]), temp);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
	// write your code here
        Map<String,Integer> map = new Map<>();
        for(int i=0;i<20;i++){
            map.insert("ABC"+i,1+i);
            System.out.println("i=" + i + " lf=" + map.loadFactor());
        }

        map.removeKey("ABC3");
        map.removeKey("ABC12");

        for (int i=0;i<20;i++){
            System.out.println("ABC"+i + ":" + map.getValue("ABC"+i));
        }
        int[] arr = {3,7,9,6,2,6,5,9,-10,10,64,6};
        System.out.println("Element occurs max time is : " + maxOccur(arr));
        int[] arr2 = { 2, 1, -2, 2, 3};
        printPairsWithSumZero(arr2);
        int[] arr3 = {2,6,1,2};
        int[] arr4 = {1,2,3,4,2,2};
        System.out.println(intersection(arr3,arr4));
    }
}
