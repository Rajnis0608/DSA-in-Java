package com.company;
import java.util.ArrayList;

public class PriorityQueue {
        private ArrayList<Integer> heap;

        public PriorityQueue() {
            heap = new ArrayList<>();
        }

        boolean isEmpty() {
            return heap.size()==0;
        }

        int size() {
            return heap.size();
        }

        int getMin() throws PriorityQueueException{
            if(heap.size() == 0){
                throw new PriorityQueueException();
            }
            return heap.get(0);
        }

        void insert(int element){
            heap.add(element);
            //upheapify
            int childIndex = heap.size()-1;
            int parentIndex = (childIndex-1)/2;
            while (childIndex > 0 && heap.get(childIndex) < heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }

        }

        int removeMin() throws PriorityQueueException{
            if(heap.size() == 0){
                throw new PriorityQueueException();
            }
            int ans = heap.get(0);
            heap.set(0,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);

            //downheapify
            int parentIndex = 0;
            int leftChildIndex = 1;
            int rightChildIndex = 2;
            int minIndex = 0;
            while (leftChildIndex < heap.size()){
                if (heap.get(leftChildIndex) < heap.get(minIndex)) {
                    minIndex = leftChildIndex;
                }
                if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
                    minIndex = rightChildIndex;
                }
                if (minIndex == parentIndex){
                    return ans;
                }

                //Swap
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(minIndex));
                heap.set(minIndex, temp);
                parentIndex = minIndex;
                leftChildIndex = 2 * parentIndex + 1;
                rightChildIndex = 2 * parentIndex + 2;
            }
            return ans;
        }

}
