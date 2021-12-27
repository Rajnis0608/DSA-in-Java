package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;

    private void printLevelWise(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> current = pendingNodes.poll();
            System.out.print(current.data + ":");
            if(current.left != null){
                System.out.print("L-" + current.left.data);
                pendingNodes.offer(current.left);
            }
            if(current.right != null){
                System.out.print(" R-" + current.right.data);
                pendingNodes.offer(current.right);
            }
            System.out.println();
        }
    }

    public void printTree() {
        printLevelWise(root);
    }

    private BinaryTreeNode<Integer> insertDataHelper(int data,BinaryTreeNode<Integer> root){
        if(root == null){
            BinaryTreeNode<Integer> ans = new BinaryTreeNode<>(data);
            return ans;
        }
        if (root.data > data){
            root.left = insertDataHelper(data,root.left);
        }
        else {
            root.right = insertDataHelper(data,root.right);
        }
        return root;
    }

    public void insertData(int data){
        root = insertDataHelper(data,root);
    }

    private BinaryTreeNode<Integer> deleteDataHelper(int data,BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }
       if (root.data < data){
           root.right = deleteDataHelper(data,root.right);
           return root;
       } else if(root.data > data){
           root.left = deleteDataHelper(data,root.left);
       }
       else {
           if(root.left == null && root.right == null){
               return null;
           }else if (root.left == null){
               return root.right;
           }else if (root.right == null){
               return root.left;
           }
           else {
               BinaryTreeNode<Integer> minNode = root.right;
               while (minNode.left != null){
                   minNode = minNode.left;
               }
               root.data = minNode.data;
               root.right = deleteDataHelper(minNode.data, root.right);
               return root;
           }
       }
       return root;
    }

    public void deleteData(int data){
        root = deleteDataHelper(data,root);
    }

    private boolean hasDataHelper(int data,BinaryTreeNode<Integer> root){
        if(root == null) {
            return false;
        }
        if(root.data == data){
            return true;
        }
        else if (root.data < data){
            return hasDataHelper(data,root.right);
        }else {
            return hasDataHelper(data,root.left);
        }
    }

    public boolean hasData(int data){
        return hasDataHelper(data,root);
    }

}
