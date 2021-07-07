package com.javalearning;

public class Main {

    public static void main(String[] args) {
//        LinkedList<Integer> ll1 = new LinkedList<>();
//        ll1.add(2);
//        ll1.add(3);
//        ll1.add(4);
//        ll1.print();
//        ll1.insert(5,1);
//        ll1.print();
//        ll1.insert(1,0);
//        ll1.print();
//        System.out.println(ll1.midpoint());
//        ll1.delete(2);
//        ll1.print();
//        System.out.println(ll1.midpoint());
//        ll1.delete(0);
//        ll1.print();

        LinkedListR<Integer> ll2 = new LinkedListR<>();
        ll2.add(2);
        ll2.add(3);
        ll2.add(4);
        ll2.add(1);
        ll2.print();
        ll2.reverse();
        ll2.print();
        ll2.insert(2,6);
        ll2.print();
        ll2.insert(0,8);
        ll2.print();
        ll2.deleteR(3);
        ll2.print();
        ll2.deleteR(0);
        ll2.print();
        ll2.getSize();
    }
}

