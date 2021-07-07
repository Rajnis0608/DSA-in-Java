package com.javalearning;

class Node<T> {
    T data;
    Node<T> next;
}

public class LinkedList<T> {
    Node<T> head;
    private int size ;

    LinkedList() {
        head = null;
        size = 0;
    }

    public void add(T elem) {
        Node<T> temp = new Node<>();
        temp.data = elem;
        temp.next = null;
        if(head == null) {
            head = temp;
            return;
        }
        Node<T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = temp;
        size++;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insert(T elem,int pos) {
        Node<T> temp = new Node<>();
        temp.data = elem;
        temp.next = null;
        if(pos == 0) {
            temp.next = head;
            head = temp;
            return;
        }
        int i = 0;
        Node<T> current = head;
        while (i < pos-1) {
            current  = current.next;
            i++;
        }
        temp.next = current.next;
        current.next = temp;
        size++;
    }

    public void delete(int pos) {
        if(pos < size) {
            Node<T> temp = head;
            if (pos == 0) {
                head = head.next;
                temp.next = null;
                return;
            }

            int i = 0;
            while (i < pos - 1) {
                temp = temp.next;
                i++;
            }
            Node<T> toDelete = temp.next;
            temp.next = temp.next.next;
            toDelete.next = null;
            size--;
        }
        else {
            System.out.println("Invalid index");
        }
    }

    public T midpoint() {
        Node<T> slow = head;
        Node<T> fast = head;
        while ( fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }






}

















