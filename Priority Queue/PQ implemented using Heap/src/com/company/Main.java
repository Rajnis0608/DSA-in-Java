package com.company;

public class Main {

    private static void insertIntoVirtualHeap(int[] arr,int i){
        int childIndex = i;
        int parentIndex = (childIndex-1)/2;
        while (childIndex > 0 && arr[childIndex] < arr[parentIndex]){
            int temp = arr[childIndex];
            arr[childIndex] = arr[parentIndex];
            arr[parentIndex] = temp;
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
    }

    private static int removeFromVirtualHeap(int arr[],int heapSize) {
        int ans = arr[0];
        arr[0] = arr[heapSize-1];
        heapSize--;
        int parentIndex = 0;
        int leftIndex = 2*parentIndex+1;
        int rightIndex = 2*parentIndex+2;
        int minIndex = 0;
        while (leftIndex < heapSize){
            if(arr[leftIndex] < arr[minIndex]){
                minIndex = leftIndex;
            }
            if(rightIndex < heapSize && arr[rightIndex] < arr[minIndex]){
                minIndex = rightIndex;
            }
            if (minIndex != parentIndex){
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[minIndex];
                arr[minIndex] = temp;
                parentIndex = minIndex;
                leftIndex = 2*parentIndex+1;
                rightIndex = 2*parentIndex+2;
            }else {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws PriorityQueueException{
	    PriorityQueue pq = new PriorityQueue();
        int arr[] = {5,1,9,2,0,6};
        for(int i=0;i<arr.length;i++){
            //pq.insert(arr[i]);
            insertIntoVirtualHeap(arr,i);
        }

        for (int i=0;i<arr.length;i++){
            arr[arr.length-1-i] = removeFromVirtualHeap(arr,arr.length-i);
        }

        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
//        while (!pq.isEmpty()){
//            System.out.print(pq.removeMin() + " ");
//        }
//        System.out.println();
    }
}
