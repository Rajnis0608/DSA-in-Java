package com.javalearning;

import java.util.ArrayList;

public class SortingArray {

    public static void insert(ArrayList<Integer>arr,int ele){
        if (arr.size() == 0 || arr.get(arr.size()-1) <= ele){
            arr.add(ele);
            return;
        }
        int temp = arr.remove(arr.size()-1);
        insert(arr,ele);
        arr.add(temp);
    }

    public static void sort(ArrayList<Integer> arr){
        if (arr.size() == 1){
            return;
        }
        int ele = arr.remove(arr.size()-1);
        sort(arr);
        insert(arr,ele);

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(1);
        arr.add(3);
        arr.add(9);
        arr.add(4);
        System.out.println(arr);
        sort(arr);
        System.out.println(arr);
    }
}
