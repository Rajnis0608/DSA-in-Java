package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

class MaxPQComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2){
            return 1;
        }
        if(o1 > o2){
            return -1;
        }
        return 0;
    }
}

public class InbuiltMaxHeap {
    public static void main(String[] args) {
        MaxPQComparator maxComparator = new MaxPQComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(maxComparator);
        int arr[] = {9,1,0,4,7,3};
        for (int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
        System.out.println();

    }
}
