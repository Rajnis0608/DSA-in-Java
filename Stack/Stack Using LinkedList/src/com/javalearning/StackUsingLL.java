package com.javalearning;

class Node<T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
    }
}

public class StackUsingLL<T> {

    private Node<T> top;
    private int size;

    public StackUsingLL() {
        top = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public T top() throws StackIsEmpty{
        if(top == null){
            throw new StackIsEmpty();
        }
        return top.data;
    }

    public void push(T x) {
        Node<T> temp = new Node<>(x);
        temp.next = top;
        top = temp;
        size++;
    }

    public T pop() throws StackIsEmpty {
        if(size == 0) {
            throw new StackIsEmpty();
        }
        T temp = top.data;
        top = top.next;
        return temp;
    }

    public void print() {
        Node temp = top;
        String s = "";
        while (temp != null){
            s += temp.data  + " ";
            temp = temp.next;
        }
        System.out.println(s);
    }

    @Override
    public String toString() {
        Node temp = top;
        String s = "";
        while (temp != null) {
            s += temp.data  + " ";
            temp = temp.next;
        }
        return s;
    }
}
