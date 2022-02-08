package com.javalearning;

import java.util.Stack;

public class ReverseStack {
    public static void insertAtLast(Stack<Integer> st,int ele){
        if (st.isEmpty()){
            st.push(ele);
            return;
        }
        int temp = st.pop();
        insertAtLast(st,ele);
        st.push(temp);
    }

    public static void reverseStack(Stack<Integer> st){
        if (st.size() == 1){
            return;
        }
        int temp = st.pop();
        reverseStack(st);
        insertAtLast(st,temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(5);
        st.push(32);
        st.push(20);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }
}
