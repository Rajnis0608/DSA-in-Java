package com.company;

import java.util.*;

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

    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("Enter root data : ");
        int rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.offer(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> currentNode = pendingNodes.poll();

            System.out.println("Enter left child of " + currentNode.data + " : ");
            int leftChild = s.nextInt();
            if(leftChild != -1){
                TreeNode<Integer> leftRoot = new TreeNode<>(leftChild);
                currentNode.left = leftRoot;
                pendingNodes.offer(leftRoot);
            }

            System.out.println("Enter right child of " + currentNode.data + " : ");
            int rightChild = s.nextInt();
            if(rightChild != -1){
                TreeNode<Integer> rightRoot = new TreeNode<>(rightChild);
                currentNode.right = rightRoot;
                pendingNodes.offer(rightRoot);
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        while (!pendingNodes.isEmpty()){
            TreeNode<Integer> current = pendingNodes.poll();
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

    public static int countNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count = 0;
        count = count + countNodes(root.left);
        count = count + countNodes(root.right);
        return count+1;
    }

    public static int height(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }

    public static int diameter(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int opt1 = height(root.right) + height(root.left);
        int opt2 = diameter(root.left);
        int opt3 = diameter(root.right);
        return Math.max(opt1,Math.max(opt2,opt3));
    }

    public static Pair<Integer,Integer>diameterAndHeight(TreeNode<Integer> root){
        if (root == null){
            Pair<Integer,Integer> output = new Pair<>();
            output.data1 = 0;
            output.data2 = 0;
            return output;
        }
        Pair<Integer,Integer> leftOutput = diameterAndHeight(root.left);
        Pair<Integer,Integer> rightOutput = diameterAndHeight(root.right);
        int finalHeight = 1+Math.max(leftOutput.data2,rightOutput.data2);
        int option1 = leftOutput.data2 + rightOutput.data2;
        int option2 = leftOutput.data1;
        int option3 = rightOutput.data1;
        int finalDia = Math.max(option1,Math.max(option2,option3));
        Pair<Integer,Integer> ans = new Pair<>();
        ans.data1 = finalDia;
        ans.data2 = finalHeight;
        return ans;
    }

    public static void preorder(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(TreeNode<Integer> root){
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");

    }

    public static void inorder(TreeNode<Integer> root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static TreeNode<Integer> treeBuilderFromPreAndIn(int[] pre, int[] in, int ps, int pe, int is, int ie){
        if(is > ie){
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(pre[ps]);
        int rootIndex = -1;
        for(int i=0;i<in.length;i++){
            if(in[i] == root.data){
                rootIndex = i;
                break;
            }
        }
        int leftis = is;
        int leftie = rootIndex-1;
        int leftps = ps+1;
        int leftpe = leftps+leftie-leftis;
        int rightps = leftpe+1 ;
        int rightpe = pe;
        int rightis = rootIndex+1;
        int rightie = ie;

        root.left = treeBuilderFromPreAndIn(pre,in,leftps,leftpe,leftis,leftie);
        root.right = treeBuilderFromPreAndIn(pre,in,rightps,rightpe,rightis,rightie);
        return root;
    }

    public static TreeNode<Integer> treeBuilderFromPreAndIn(int[] pre, int[] in){
        return treeBuilderFromPreAndIn(pre,in,0,pre.length-1,0,in.length-1);
    }

    private static TreeNode<Integer> treeBuilderFromPostAndIn(int[] post, int[] in, int ps, int pe, int is, int ie){
        if(is > ie){
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(post[pe]);
        int rootIndex = -1;
        for(int i=0;i<in.length;i++){
            if(root.data == in[i]){
                rootIndex = i;
                break;
            }
        }
        int leftis = is;
        int leftie = rootIndex-1;
        int leftps = ps;
        int leftpe = leftps+leftie-leftis;
        int rightis = rootIndex+1;
        int rightie = ie;
        int rightps = leftpe+1;
        int rightpe = pe-1;

        root.left = treeBuilderFromPostAndIn(post,in,leftps,leftpe,leftis,leftie);
        root.right = treeBuilderFromPostAndIn(post,in,rightps,rightpe,rightis,rightie);
        return root;
    }

    public static TreeNode<Integer>treeBuilderFromPostAndIn(int[] post,int[] in){
        return treeBuilderFromPostAndIn(post,in,0,post.length-1,0,in.length-1);
    }

    public static boolean isPresent(TreeNode<Integer>root,int x){
        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }
        boolean left = isPresent(root.left,x);
        boolean right = isPresent(root.right,x);
        return left|right;
    }

    public static TreeNode<Integer> mirror(TreeNode<Integer> root){
        if(root == null){
            return null;
        }
        TreeNode<Integer> temp = root.right;
        root.right = mirror(root.left);
        root.left = mirror(temp);
        return root;
    }

    public static int sum(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        return root.data+sum(root.left)+sum(root.right);
    }

    public static TreeNode<Integer> removeLeaf(TreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeaf(root.left);
        root.right = removeLeaf(root.right);
        return root;
    }

    /*************PENDING*********************/
    public static ArrayList<LinkedList<Integer>> levelWiseLinkedList(TreeNode<Integer> root){
        ArrayList<LinkedList<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> rootData = new LinkedList<>();
        rootData.add(root.data);
        ans.add(rootData);
        return ans;
    }

    /************BST Operations**************/
    public static int maximum(TreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));
    }

    public static int minimum(TreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right)));
    }

    public static boolean searchElement(TreeNode<Integer> root,int x){

        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }
        if(x < root.data){
            return searchElement(root.left,x);
        }
        if(x > root.data){
            return searchElement(root.right,x);
        }
        return false;
    }

    public static boolean isBST1(TreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftHighest = maximum(root.left);
        int rightLowest = minimum(root.right);
        if(leftHighest >= root.data ){
            return false;
        }
        if(rightLowest < root.data){
            return false;
        }
        boolean isLeftTrue = isBST1(root.left);
        boolean isRightTrue = isBST1(root.right);

        if(isLeftTrue && isLeftTrue){
            return true;
        }
        return false;
    }

    public static Pair<Boolean , Pair<Integer,Integer>> isBST2(TreeNode<Integer> root){
        if(root == null){
            Pair<Boolean , Pair<Integer,Integer>> output = new Pair<>();
            output.data1 = true;
            output.data2 = new Pair<>();
            output.data2.data1 = Integer.MAX_VALUE;
            output.data2.data2 = Integer.MIN_VALUE;
            return output;
        }
        Pair<Boolean , Pair<Integer,Integer>> leftOutput = isBST2(root.left);
        Pair<Boolean , Pair<Integer,Integer>> rightOutput = isBST2(root.right);
        int min = Math.min(leftOutput.data2.data1,Math.min(rightOutput.data2.data1,root.data));
        int max = Math.max(leftOutput.data2.data2,Math.max(rightOutput.data2.data2,root.data));
        boolean isBst = (root.data > leftOutput.data2.data2) & (root.data < rightOutput.data2.data1)
                & leftOutput.data1 & rightOutput.data1;
        Pair<Boolean , Pair<Integer,Integer>> output = new Pair<>();
        output.data1 = isBst;
        output.data2 = new Pair<>();
        output.data2.data1 = min;
        output.data2.data2 = max;
        return output;
    }

    public static Boolean isBST3(TreeNode<Integer> root,int a,int b){
        if (root == null){
            return true;
        }
        if(root.data < a || root.data > b){
            return false;
        }
        return isBST3(root.left,a,root.data) && isBST3(root.right,root.data,b);
    }

    private static TreeNode<Integer> BSTFromArray(int[] arr,int si,int ei){
        if(ei < si){
            return null;
        }
        int mid = (ei+si)/2;
        TreeNode<Integer> root = new TreeNode<>(arr[mid]);
        root.left = BSTFromArray(arr,si,mid-1);
        root.right = BSTFromArray(arr,mid+1,ei);
        return root;
    }

    /*************PENDING*********************/
    public static TreeNode<Integer> BSTFromArray(int[] arr){
        Arrays.sort(arr);
        return BSTFromArray(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
    //  TreeNode<Integer> root = takeInput(scanner);
    //  TreeNode<Integer> root = takeInputLevelWise();
//        int[] pre = {1,2,4,6,5,3};
//        int[] in = {6,4,2,5,1,3};
//        int[] post = {6,4,5,2,3,1};
//        TreeNode<Integer> root = treeBuilderFromPostAndIn(post,in);
//        printRecursive(root);
//        printLevelWise(root);
//        System.out.println("Number of nodes : " + countNodes(root));
//        System.out.println("Height of tree : " + height(root));
//        System.out.println("Diameter of tree is : " + diameter(root));
//        Pair<Integer,Integer> dnh = diameterAndHeight(root);
//        System.out.println("Diameter : " + dnh.data1 + " Height : " + dnh.data2) ;
//        preorder(root);
//        System.out.println();
//        inorder(root);
//        System.out.println();
//        postorder(root);
//        System.out.println();
//        System.out.println("Is 5 present : "+isPresent(root,5));
//        System.out.println("Is 9 present : "+isPresent(root,9));
//        TreeNode<Integer> mirrored = mirror(root);
//        printLevelWise(root);
//        System.out.println("Sum of all the nodes is : " + sum(root));
//        removeLeaf(root);
//        printLevelWise(root);

        //BST Testing
//        TreeNode<Integer> rootBST = takeInputLevelWise(); //// 15 10 19 5 12 18 -1 -1 6 -1 -1 -1 -1 -1 -1
//        printLevelWise(rootBST);
//        System.out.println("Is 2 present : " + searchElement(rootBST,2));
//        System.out.println("Is 6 present : " + searchElement(rootBST,6));
//        System.out.println("Is 18 present : " + searchElement(rootBST,18));
//
//        System.out.println("Min of tree : " + minimum(rootBST));
//        System.out.println("Max of tree : " + maximum(rootBST));
//
//        System.out.println("Is Tree a BST 1 : " + isBST1(rootBST) );
//        System.out.println("Is Tree a BST 2 : " + isBST2(rootBST).data1 );
//        System.out.println("Min of tree : " + isBST2(rootBST).data2.data1);
//        System.out.println("Max of tree : " + isBST2(rootBST).data2.data2);
//        System.out.println("Is Tree a BST 3 : " + isBST3(rootBST,Integer.MIN_VALUE,Integer.MAX_VALUE));
        int[] arrayToBST = {19,21,50,14,8,30,42};
        TreeNode<Integer> BSTFromArr = BSTFromArray(arrayToBST);
        printLevelWise(BSTFromArr);
    }


}
