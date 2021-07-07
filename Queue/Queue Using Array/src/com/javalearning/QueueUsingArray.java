package com.javalearning;

import java.util.function.ObjDoubleConsumer;

public class QueueUsingArray<T> {
    private T[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray(){
        data = (T[]) new Object[10];
        front = -1;
        rear = -1;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T front() throws QueueIsEmpty{
        if(size == 0){
            throw new QueueIsEmpty();
        }
        return data[front];
    }

    public void enqueue(T elem) {
        if(size == data.length){
            T[] temp = data;
            data = (T[]) new Object[2*size];
            int k = 0;
            for(int i=front ; i < temp.length ; i++) {
                data[k] = temp[i];
                k++;
            }
            for(int i = 0; i <= rear ; i++){
                data[k] = temp[i];
                k++;
            }
            front = 0;
            rear = temp.length-1;
        }
        if(size == 0){
            front++;
        }
        rear = (rear+1) % data.length;
        size++;
        data[rear] = elem;
    }

    public T dequeue() throws QueueIsEmpty{
        if(size == 0){
            throw new QueueIsEmpty();
        }

        T temp = data[front];
        front = (front+1) % data.length;
        size--;
        if(size == 0){
            front = -1;
            rear = -1;
        }
        return temp;
    }

    public void print() {
        if(rear >= front) {
            for (int i = front; i <=rear; i++){
                System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = front; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        for (int i = 0; i <= rear ; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
