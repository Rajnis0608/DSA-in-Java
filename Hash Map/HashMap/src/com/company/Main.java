package com.company;

public class Main {

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


    }
}
