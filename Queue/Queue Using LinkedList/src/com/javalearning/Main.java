package com.javalearning;

public class Main {

    public static void main(String[] args) throws Exception {
        QueueUsingLinkedList<Integer> q = new QueueUsingLinkedList<>();
        System.out.println("Empty:" + q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.print();
        System.out.println("Size:" + q.size());
        System.out.println("Front:" + q.front());
        System.out.println("Empty:" + q.isEmpty());
        q.dequeue();
        q.print();
        q.dequeue();
        q.print();
    }
}
