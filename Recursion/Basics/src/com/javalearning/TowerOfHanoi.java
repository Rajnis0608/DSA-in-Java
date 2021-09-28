package com.javalearning;

public class TowerOfHanoi {
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        if(disks == 1){
            System.out.println(source+ " " + destination);
            return;
        }
        towerOfHanoi(disks-1,source,destination,auxiliary);
        towerOfHanoi(1,source,auxiliary,destination);
        towerOfHanoi(disks-1,auxiliary,source,destination);
    }

    public static void main(String[] args) {
        towerOfHanoi(2,'a','b','c');
        System.out.println();
        towerOfHanoi(3,'a','b','c');
    }
}
