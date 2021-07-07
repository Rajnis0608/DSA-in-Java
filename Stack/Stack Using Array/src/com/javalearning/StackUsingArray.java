package com.javalearning;

public class StackUsingArray<T> {
    public T data[];
    private int top;
    private int size;

    public StackUsingArray() {
        data =(T[]) new Object[10];
        top = -1;
        size = 0;
    }

    public StackUsingArray(int Q) {
        this.data =(T[]) new Object[Q];
        top = -1;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T top() throws StackIsEmpty {
        if(top == -1) {
            throw new StackIsEmpty();
        }
        return data[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public void push(T x){
        if(size == data.length) {
            T temp[] = data;
            data = (T[]) new Object[2*data.length];
            for(int i=0 ; i < temp.length ; i++) {
                data[i] = temp[i];
            }
        }
        top++;
        size++;
        data[top] = x;
        return;
    }

    public T pop() throws StackIsEmpty{
        if(top == -1) {
            throw new StackIsEmpty();
        }
        T temp = data[top];
        top--;
        size--;
        return temp;
    }

    public void print() {
        for(int i = size-1;i >= 0; i--){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
