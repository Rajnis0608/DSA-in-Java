package com.javalearning;

import java.util.Stack;

public class DeletingMidOfStack {
    public static int deleteMid(Stack<Integer> st,int pos){
        if (pos == 0){
            return st.pop();
        }
        int temp = st.pop();
        int ans = deleteMid(st,pos - 1);
        st.push(temp);
        return ans;
    }

    public static int deleteMid(Stack<Integer> st){
        return deleteMid(st,st.size()/2);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(5);
        st.push(32);
        st.push(20);
        st.push(55);
        System.out.println(st);
        System.out.println(deleteMid(st));
        System.out.println(st);
    }
}
