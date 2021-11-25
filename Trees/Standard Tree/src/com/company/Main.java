package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static TreeNode<Integer> takeRecursiveInput(Scanner s){
        System.out.println("Enter node data : ");
        TreeNode<Integer> root = new TreeNode<>(s.nextInt());
        System.out.println("Enter number of children : ");
        int childCount = s.nextInt();
        for(int i=0;i<childCount;i++){
            TreeNode<Integer> child = takeRecursiveInput(s);
            root.children.add(child);
        }
        return root;
    }

    public static void recursivePrint(TreeNode<Integer> root) {
        System.out.print(root.data + ":");
        for(int i=0;i<root.children.size();i++){
            System.out.print(root.children.get(i).data + ",");
        }
        System.out.println();
        for (int j=0;j<root.children.size();j++){
            recursivePrint(root.children.get(j));
        }
    }

    public static TreeNode<Integer> takeInputLevelWise(Scanner s){
        System.out.println("Enter Root data");
        TreeNode<Integer> root = new TreeNode<>(s.nextInt());
        Queue<TreeNode<Integer>>pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        while(!pendingNodes.isEmpty()) {
            TreeNode<Integer> current = pendingNodes.poll();
            System.out.println("Enter number of children of " + current.data);
            int childCount = s.nextInt();
            for (int i = 0; i < childCount; i++) {
                System.out.println("Enter child " + (i + 1) + " of " + current.data);
                TreeNode<Integer> child = new TreeNode<>(s.nextInt());
                pendingNodes.offer(child);
                current.children.add(child);
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> current = pendingNodes.poll();
            System.out.print(current.data + ":");
            for(int i=0;i<current.children.size();i++){
                System.out.print(current.children.get(i).data + ",");
                pendingNodes.offer(current.children.get(i));
            }
            System.out.println();
        }
    }

    public static int countNode(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0;i<root.children.size();i++){
            count += countNode(root.children.get(i));
        }
        return count+1;
    }

    public static int largestNode(TreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int ans = root.data;
        for (int i=0;i<root.children.size();i++){
            if(ans < largestNode(root.children.get(i))){
                ans = largestNode(root.children.get(i));
            }
        }
        return ans;
    }

    public static int height(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        for(int i=0;i<root.children.size();i++){
            if(ans < height(root.children.get(i))){
                ans = height(root.children.get(i));
            }
        }
        return 1+ans;
    }

    public static void atDepthK(TreeNode<Integer> root,int t){
        if(t < 0){
            return;

        }
        if(t == 0){
            System.out.print(root.data + " ");
            return;
        }
        for(int i=0;i<root.children.size();i++){
            atDepthK(root.children.get(i),t-1);
        }
    }

    public static int countLeaf(TreeNode<Integer>root){
        if(root.children.size() == 0){
            return 1;
        }
        int ans = 0;
        for(int i=0;i<root.children.size();i++){
            ans += countLeaf(root.children.get(i));
        }
        return ans;
    }

    public static void preorder(TreeNode<Integer>root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        for (int i=0;i<root.children.size();i++){
            preorder(root.children.get(i));
        }
    }

    public static void postorder(TreeNode<Integer>root){
        if (root == null){
            return;
        }
        for (int i=0;i<root.children.size();i++){
            preorder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }

    public static void levelorder(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> current = pendingNodes.poll();
            System.out.print(current.data + " ");
            for(int i=0;i<current.children.size();i++) {
                pendingNodes.offer(current.children.get(i));
            }
        }
    }

    public static int sumOfNodes(TreeNode<Integer>root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        for(int i=0;i<root.children.size();i++){
            ans += sumOfNodes(root.children.get(i));
        }
        return ans+root.data;
    }

    public static int rootsGreaterThanX(TreeNode<Integer>root,int x){
        if(root == null){
            return 0;
        }
        int ans = 0;
        for (int i=0;i<root.children.size();i++){
            ans += rootsGreaterThanX(root.children.get(i),x);
        }
        if(root.data > x){
            return ans+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        TreeNode<Integer> root = takeInput(scanner);
//        print(root);
        TreeNode<Integer> rootLevelWise = takeInputLevelWise(scanner);
        printLevelWise(rootLevelWise);
        System.out.println("Number of nodes : "+countNode(rootLevelWise));
        System.out.println("Largest among the given nodes is : " + largestNode(rootLevelWise));
        System.out.println("Height of tree is : " + height(rootLevelWise));
        atDepthK(rootLevelWise,2);
        System.out.println();
        System.out.println("Number of leaf nodes : " + countLeaf(rootLevelWise));
        preorder(rootLevelWise);
        System.out.println();
        postorder(rootLevelWise);
        System.out.println();
        levelorder(rootLevelWise);
        System.out.println("Sum of all the nodes is : " + sumOfNodes(rootLevelWise));
        System.out.println("Number of nodes greater than 5 : " + rootsGreaterThanX(rootLevelWise,5));
    }
}
