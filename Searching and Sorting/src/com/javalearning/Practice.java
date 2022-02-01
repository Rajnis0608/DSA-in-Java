package com.javalearning;

public class Practice {

    public static int binarySearch(int[] arr,int ele){
        int front = 0;
        int rare = arr.length - 1;
        while (rare >= front){
            int mid = (front + rare)/2;
            if (arr[mid] == ele){
                return mid;
            } else if(ele > arr[mid]){
                front = mid + 1;
            }else {
                rare = mid - 1;
            }
        }
        return -1;
    }

    public static void selectionSort(int[] arr){
        for(int i = 0;i < arr.length-1;i++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i+1;j < arr.length;j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int ele = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > ele){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ele;
        }
    }

    public static int[] merge(int[] arr1,int[] arr2){
        int ans[] = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                ans[k++] = arr1[i++];
            }else {
                ans[k++] = arr2[j++];
            }
        }
        while (i < arr1.length){
            ans[k++] = arr1[i++];
        }
        while (j < arr2.length){
            ans[k++] = arr2[j++];
        }
        return ans;
    }

    public static void print(int[] arr) {
        for (int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {7,2,9,8,4,3};
        selectionSort(arr1);
        System.out.println("Selection Sort");
        print(arr1);

        System.out.println("Bubble Sort");
        int[] arr2 = {7,2,9,8,4,3};
        bubbleSort(arr2);
        print(arr2);

        System.out.println("Insertion Sort");
        int[] arr3 = {7,2,9,8,4,3};
        insertionSort(arr3);
        print(arr3);

        System.out.println("Merging two sorted array");
        int[] arr4 = {1,5,6,7,8};
        int[] ans = merge(arr3,arr4);
        print(ans);

        System.out.println(binarySearch(arr2,8));
        System.out.println(binarySearch(arr2,0));
    }

}
