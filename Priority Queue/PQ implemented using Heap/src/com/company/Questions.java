package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length()){
            return -1;
        }
        if(o1.length() > o2.length()){
            return 1;
        }
        return 0;
    }
}


public class Questions {

    public static void printStringPQ(String[] str) {
        //Compared based on lengths
        StringLengthComparator stringLengthComparator = new StringLengthComparator();
        PriorityQueue<String> pq = new PriorityQueue<>(stringLengthComparator);
        for (int i=0;i<str.length;i++){
            pq.add(str[i]);
        }

        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }

    public static void sortKSorted(int arr[],int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for (;i<k;i++){
            pq.add(arr[i]);
        }
        for (;i<arr.length;i++) {
            arr[i-k] = pq.remove();
            pq.add(arr[i]);
        }
        for (int j=arr.length-k;j<arr.length;j++){
            arr[j] = pq.remove();
        }
    }

    public static void prinkKLsrgest(int arr[],int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for (i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for (;i<arr.length;i++){
            int min = pq.peek();
            if(min < arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,9,6,8};
        int k = 3;
        sortKSorted(arr,k);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int[] arr2 = {2,15,8,9,12,13,20};
        prinkKLsrgest(arr2,3);
        System.out.println();
        String[] s = {"this","at","a","their","queues"};
        printStringPQ(s);
    }
}
