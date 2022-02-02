package com.javalearning;

public class PrintSubset {
    public static void printSubset(String input,String output) {
        if (input.length() == 0){
            System.out.println(output);
            return;
        }
        String output1 = output + input.charAt(0);
        String output2 = output;
        if (input.length() == 1){
            input = "";
        }else {
            input = input.substring(1);
        }
        printSubset(input,output1);
        printSubset(input,output2);
    }

    public static void main(String[] args) {
        printSubset("abc","");
    }
}
