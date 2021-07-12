package com.javalearning;

import com.sun.source.tree.Tree;


//   TODO PRINTING LEVEL WISE

import java.util.Scanner;

public class Main {

    public static TreeNode<Integer> takeInput(Scanner scanner) {
        int n;
        System.out.println("Enter next node data ");
        n = scanner.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter number of children for " + n);
        int chldCount = scanner.nextInt();
        for(int i=0;i<chldCount;i++){
            TreeNode<Integer> child = takeInput(scanner);
            root.children.add(child);
        }
        return root;
    }

    public static void print(TreeNode<Integer> root) {
        String s = root.data + ":";
        for(int i = 0;i < root.children.size(); i++) {
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for(int i = 0;i < root.children.size(); i++){
            print(root.children.get(i));
        }
    }

    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Root data");
        int rootData = scanner.nextInt();
        QueueUsingLinkedList<TreeNode<Integer>>pendingNodes = new QueueUsingLinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()){
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter number of children of " + frontNode.data);
                int numChildren = scanner.nextInt();
                for (int i=0; i < numChildren; i++){
                    System.out.println("Enter " + (i+1) +"th child of " + frontNode.data);
                    int child = scanner.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    pendingNodes.enqueue(childNode);
                }
            } catch (Exception e) {
                //Shouldn't come
                return null;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode<Integer> rootNode = takeInputLevelWise();
        print(rootNode);

        Scanner scanner = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(scanner);
        print(root);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(3);
//        TreeNode<Integer> node3 = new TreeNode<>(5);
//        TreeNode<Integer> node4 = new TreeNode<>(6);
//
//        root.children.add(node2);
//        root.children.add(node3);
//        root.children.add(node4);
//
//        System.out.println(root);

    }
}
