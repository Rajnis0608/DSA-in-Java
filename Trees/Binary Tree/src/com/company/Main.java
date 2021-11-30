package com.company;

import java.util.Scanner;

public class Main {

    public static TreeNode<Integer> takeInput(Scanner s){
        System.out.println("Enter node data : ");
        int data = s.nextInt();
        if(data == -1){
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(data);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }

    public static void printRecursive(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + ":");
        if(root.left != null){
            System.out.print("L-" + root.left.data);
        }
        if(root.right != null){
            System.out.print(" R-" + root.right.data);
        }
        System.out.println();
        printRecursive(root.left);
        printRecursive(root.right);
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(scanner);
        printRecursive(root);
    }
}
