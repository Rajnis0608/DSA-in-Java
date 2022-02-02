package com.javalearning;

public class TowerOfHanoi {
    public static int a = 0;
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        a++;
        System.out.println(a);
        if(disks == 1){
            System.out.println(source+ " to " + destination);
            return;
        }
        towerOfHanoi(disks-1,source,destination,auxiliary);
        System.out.println(source+ "to " + destination);
        towerOfHanoi(disks-1,auxiliary,source,destination);
    }

    public static void main(String[] args) {
        towerOfHanoi(3,'a','b','c');
        System.out.println(a);
    }
}
