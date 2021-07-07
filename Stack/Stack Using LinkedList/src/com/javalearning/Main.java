package com.javalearning;

public class Main {

    public static void main(String[] args) throws StackIsEmpty {
        StackUsingLL s = new StackUsingLL();
        s.push(2);
        s.push(3);
        System.out.println(s);
        s.print();
        System.out.println("top:" + s.top());
        System.out.println("Size:" + s.size());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println(s);
        System.out.println("isEmpty:" + s.isEmpty());
        s.pop();
    }
}
