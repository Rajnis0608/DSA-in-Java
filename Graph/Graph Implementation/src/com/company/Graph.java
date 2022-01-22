package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    private static void depthFirstHelper(int[][] edges,int sv,boolean[] visited){
        System.out.print(sv + " ");
        visited[sv] = true;
        for (int i=0;i<edges.length;i++){
            if (edges[sv][i] == 1 && !visited[i]){
                depthFirstHelper(edges,i,visited);
            }
        }
    }

    public static void depthFirstSearch(int[][] edges){
        boolean[] visited = new boolean[edges.length];
        for (int i=0;i<edges.length;i++){
            if (!visited[i])
                depthFirstHelper(edges,i,visited);
        }
    }

    private static void breadthFirstHelper(int[][] edges,int sv,boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sv);
        visited[sv] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");
            for (int i=0;i<edges.length;i++){
                if (edges[current][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void breadthFirstSearch(int[][] edges){
        boolean[] visited = new boolean[edges.length];
        for (int i=0;i<edges.length;i++){
            if (!visited[i])
                breadthFirstHelper(edges,i,visited);
        }
    }

    private static boolean hasPath(int[][] edges,int sv,int ev,boolean[] visited){
        visited[sv] = true;
        for (int i=0;i<edges.length;i++){
            if (edges[sv][i] == 1 ){
                if (i == ev){
                    return true;
                }else if (visited[i]!=true){
                    return hasPath(edges,i,ev,visited);
                }
            }
        }
        return false;
    }

    public static boolean hasPath(int[][] edges,int sv,int ev){
        boolean[] visited = new boolean[edges.length];
        for (int i=0;i<edges.length;i++){
            if (!visited[i])
                if(hasPath(edges,sv,ev,visited)){
                    return true;
                }
        }
        return false;
    }

    private static ArrayList<Integer> getPath(int[][] edges,int sv,int ev,ArrayList<Integer> ans,boolean[] visited){
        if (sv == ev){
            ans.add(sv);
            return ans;
        }
        for (int i=0;i<edges.length;i++){
            if (edges[sv][i] == 1 && !visited[i]){
                if (getPath(edges,i,ev,ans,visited) != null) {
                    ans.add(sv);
                    return ans;
                }
            }
        }
        return null;
    }

    public static ArrayList<Integer> getPath(int[][] edges,int sv,int ev){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[edges.length];
        return getPath(edges,sv,ev,ans,visited);
    }

    public static void main(String[] args) {
        int n;
        int e;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        int edges[][] = new int[n][n];
        for (int i=0;i<e;i++){
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        System.out.println("DFS");
        depthFirstSearch(edges);
        System.out.println();
        System.out.println("BFS");
        breadthFirstSearch(edges);
        System.out.println();
        //Do again
        System.out.println(hasPath(edges,0,6));
        System.out.println(hasPath(edges,5,6));
        System.out.println(hasPath(edges,2,3));
        System.out.println(getPath(edges,0,4));
    }
}
