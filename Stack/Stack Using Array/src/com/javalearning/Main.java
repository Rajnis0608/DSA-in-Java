package com.javalearning;

import java.util.Stack;

public class Main {

    public static void main(String[] args) throws StackIsEmpty{
        StackUsingArray<Integer> s = new StackUsingArray<Integer>(3);
        s.push(2);
        s.push(3);
        s.push(4);
        s.print();
        try {
            s.pop();
            s.pop();
            s.pop();
            s.pop();
        }
        catch (StackIsEmpty e){
            System.out.println("Error");
        }
        System.out.println("IsEmpty:" + s.isEmpty());
        s.push(8);
        System.out.println("Size:"+ s.size());
        System.out.println("Top:" + s.top());
    }
}
