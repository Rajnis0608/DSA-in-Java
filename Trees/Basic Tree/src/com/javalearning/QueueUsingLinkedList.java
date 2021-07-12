package com.javalearning;

import java.util.LinkedList;

public class QueueUsingLinkedList<T> {

    private LinkedList<T> queue;

    QueueUsingLinkedList(){
        queue = new LinkedList<>();
    }

    public void enqueue(T data){
        queue.add(data);
    }

    public T dequeue() throws Exception{
        if(isEmpty()){
            throw new QueueIsEmpty();
        }
        T data = queue.get(0);
        queue.remove(0);
        return data;
    }

    public T front() {
        return queue.get(0);
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        if(queue.size() == 0)
            return true;
        return false;
    }

    public void print(){
        for (T a:queue) {
            System.out.print(a + " ") ;
        }
        System.out.println();
    }
}
