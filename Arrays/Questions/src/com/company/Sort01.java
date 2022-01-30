package com.company;

public class Sort01 {
    public static void main(String[] args) {
        int arr[] = {0,1,1,0,1,0,1};
        int k = 0;
        for (int i = 0 ;i < arr.length;i++){
            if (arr[i] == 0){
                arr[k] = 0;
                k++;
            }
        }
        for (;k < arr.length;k++){
            arr[k] = 1;
        }
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
