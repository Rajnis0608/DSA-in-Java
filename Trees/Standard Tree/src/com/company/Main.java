package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

    public static boolean isPresent(TreeNode<Integer> root,int x){
        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }
        boolean ans = false;
        for(int i=0;i<root.children.size();i++){
            ans = ans|isPresent(root.children.get(i),x);
        }
        return ans;
    }

    public static int rootWithChildMaxSum(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        int max = 0;
        int ans = 0;
        while (!pendingNodes.isEmpty()){
            TreeNode<Integer>current = pendingNodes.poll();
            int sum = current.data;
            for(int i=0;i<current.children.size();i++){
                sum += current.children.get(i).data;
                pendingNodes.offer(current.children.get(i));
            }
            if(max < sum){
                max = sum;
                ans = current.data;
            }
        }
        return ans;
    }

    public static boolean isIdentical(TreeNode<Integer>tree1,TreeNode<Integer>tree2){
        if(tree1==null && tree2==null){
            return true;
        }
        if(tree1==null || tree2==null){
            return false;
        }
        if(tree1.data != tree2.data){
            return false;
        }
        if(tree1.children.size() != tree2.children.size()){
            return false;
        }
        boolean ans = true;
        for(int i=0;i<tree1.children.size();i++){
            ans = ans & isIdentical(tree1.children.get(i),tree2.children.get(i));
        }
        return ans;
    }

    public static int justGreaterThanX(TreeNode<Integer>root,int x){
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        int ans = Integer.MAX_VALUE;
        while (!pendingNodes.isEmpty()){
            TreeNode<Integer>current = pendingNodes.poll();
            if(current.data > x && ans > current.data){
                ans = current.data;
            }
            for (int i=0;i<current.children.size();i++){
                pendingNodes.offer(current.children.get(i));
            }
        }
        return ans;
    }

    public static int secondLargest(TreeNode<Integer> root){
        int first = 0;int second = 0;
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        while (!pendingNodes.isEmpty()){
            TreeNode<Integer>current = pendingNodes.poll();
            if(current.data > first){
                second = first;
                first = current.data;
            }
            for (int i=0;i<current.children.size();i++){
                pendingNodes.offer(current.children.get(i));
            }
        }
        return second;
    }

    public static void replaceNodeWithDepth(TreeNode<Integer> root){
        replaceNodeWithDepth(root,0);
    }

    private static void replaceNodeWithDepth(TreeNode<Integer> root,int depth){
        if(root == null){
            return;
        }
        root.data = depth;
        for(int i=0;i<root.children.size();i++){
            replaceNodeWithDepth(root.children.get(i),depth+1);
        }
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
        System.out.println("Is 10 present : " + isPresent(rootLevelWise,10));
        System.out.println("Is 12 present : " + isPresent(rootLevelWise,12));
        System.out.println("Root with maximum sum of root and its child : "+rootWithChildMaxSum(rootLevelWise));
        //TreeNode<Integer> rootLevelWise2 = takeInputLevelWise(scanner);
        System.out.println("Is identical : " + isIdentical(rootLevelWise,rootLevelWise) );
        System.out.println("Root just greater than 5 : " + justGreaterThanX(rootLevelWise,5));
        System.out.println("Second largest node is : " + secondLargest(rootLevelWise));
        replaceNodeWithDepth(rootLevelWise);
        printLevelWise(rootLevelWise);
    }
}
//1 4 2 3 4 5 2 6 7 1 8 0 1 9 0 1 10 0 0 0