package com.javalearning;

public class LinkedListR<T> {
    Node<T> head;
    private int size ;

    LinkedListR() {
        head = null;
        size = 0;
    }

    public void add(T elem) {
        Node<T> temp = new Node<>();
        temp.data = elem;
        temp.next = null;
        if(head == null) {
            head = temp;
            size++;
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

    public void reverse(){
        head = reverse(head);
    }

    private Node<T> reverse(Node<T>head) {
        if(head == null || head.next == null){
            return head;
        }
        Node<T> reversedTail = head.next;
        Node<T> smallHead = reverse(head.next);
        reversedTail.next = head;
        head.next = null;
        return smallHead;
    }

    public void insert(int pos,T elem) {
        head = insert(head,pos,elem);
    }

    private Node<T> insert(Node<T> head,int pos,T elem){
        if(pos == 0){
            Node<T> newNode = new Node<>();
            newNode.data = elem;
            newNode.next = head;
            size++;
            return newNode;
        }
        head.next = insert(head.next,pos-1,elem);
        return head;
    }

    public void deleteR(int pos){
        head = deleteRR(head,pos);
        return;
    }

    private Node<T> deleteRR(Node<T>head,int pos ) {
        if(pos<size) {
            if (pos == 0) {
                size--;
                return head.next;
            }
            Node<T> smallAns = deleteRR(head.next,pos - 1);
            head.next = smallAns;
            return head;
        }
        else {
            System.out.println("Invalid index");
            return null;
        }

    }

    public int getSize(){
        System.out.println(size);
        return size;
    }

}
