package com.javalearning;

import java.util.Stack;

public class SortingStack {
    public static void insert(Stack<Integer> st,int ele){
        if(st.isEmpty() || st.peek() <= ele){
            st.push(ele);
            return;
        }
        int temp = st.peek();
        st.pop();
        insert(st,ele);
        st.push(temp);
    }

    public static void sort(Stack<Integer> st){
        if (st.size() == 1){
            return;
        }
        int temp = st.peek();
        st.pop();
        sort(st);
        insert(st,temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(5);
        st.push(32);
        st.push(20);
        System.out.println(st);
        sort(st);
        System.out.println(st);
    }
}
