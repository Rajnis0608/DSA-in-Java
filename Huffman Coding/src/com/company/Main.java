package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class MyComparator implements Comparator<HuffmanNode>{

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        if(o1.data < o2.data){
            return -1;
        }
        if(o1.data > o2.data){
            return 1;
        }
        return 0;
    }
}

class HuffmanNode{

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(int num,char ch){
        data = num;
        c = ch;
    }

    @Override
    public String toString() {
        return (data + ":" + c + " ");
    }

}

public class Main {

    public static HashMap<Character,Integer> getFrequencies(char[] carr) {
        HashMap<Character,Integer> frequenciesOfChar = new HashMap<>();
        for (int i=0;i< carr.length;i++){
            if(frequenciesOfChar.get(carr[i]) == null){
                frequenciesOfChar.put(carr[i],1);
            }
            else {
                int temp = frequenciesOfChar.get(carr[i]);
                frequenciesOfChar.put(carr[i],++temp);
            }
        }
        return frequenciesOfChar;
    }

    public static HashMap<Character,String> getCode(HuffmanNode root){
        HashMap<Character,String> ans = new HashMap<>();
        getCode(root,"",ans);
        return ans;
    }

    private static void getCode(HuffmanNode root, String s,HashMap<Character,String> codes) {
        if(root == null){
            return;
        }

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            codes.put(root.c,s);
            return;
        }
        getCode(root.left, s + "0",codes);
        getCode(root.right, s + "1",codes);
    }

    public static String huffmanEncode(String s,HashMap<Character,String> map){
        char charArr[] = s.toCharArray();
        String ans = "";
        for(int i=0;i<charArr.length;i++){
            ans+=map.get(charArr[i]);
        }
        return ans;
    }

    public static String huffmanDecode(String s,HashMap<Character,String> map){
        HashMap<String,Character> reverseMap = new HashMap<>();
        for(Character c:map.keySet()){
            reverseMap.put(map.get(c),c);
        }
        char[] arr = s.toCharArray();
        String ans = "";
        String temp = "";
        for(int i=0;i<arr.length;i++){
            temp+=arr[i];
            if(reverseMap.get(temp) != null){
                ans += reverseMap.get(temp);
                temp = "";
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s;

        s = scanner.nextLine();
        char[] carr = s.toCharArray();

        HashMap<Character,Integer> frequenciesOfChar = getFrequencies(carr);

        MyComparator myComparator = new MyComparator();
        PriorityQueue<HuffmanNode> frequencies = new PriorityQueue<>(myComparator);

        for (Character key : frequenciesOfChar.keySet()){
            HuffmanNode huffmanNode = new HuffmanNode(frequenciesOfChar.get(key),key);
            frequencies.add(huffmanNode);
        }

        HuffmanNode root = null;

        while (frequencies.size() > 1){
            HuffmanNode huffmanNode1 = frequencies.poll();
            HuffmanNode huffmanNode2 = frequencies.poll();

            HuffmanNode newHuffmanNode = new HuffmanNode(huffmanNode1.data+ huffmanNode2.data,'-');
            newHuffmanNode.left = huffmanNode1;
            newHuffmanNode.right = huffmanNode2;
            root = newHuffmanNode;
            frequencies.add(newHuffmanNode);
        }
        HashMap<Character,String> map = getCode(root);
        System.out.println(map);

        String str = huffmanEncode("Hello",map);
        System.out.println(huffmanEncode("Hello",map));
        System.out.println(huffmanDecode(str,map));
    }
}
