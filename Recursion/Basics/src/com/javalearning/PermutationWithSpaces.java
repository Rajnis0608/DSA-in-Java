package com.javalearning;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationWithSpaces {
    public static ArrayList<String> permutation(String input, String output, ArrayList<String> ans) {
        if(input.length() == 0){
            ans.add(output);
            return ans;
        }
        String option1 = output +" " + input.charAt(0);
        String option2 = output + input.charAt(0);
        String smallInput = input.substring(1);
        permutation(smallInput,option1,ans);
        permutation(smallInput,option2,ans);
        return ans;
    }

    public static ArrayList<String> permutation(String S){
        ArrayList<String> ans = new ArrayList<>();
        permutation(S.substring(1),S.substring(0,1),ans);
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(PermutationWithSpaces.permutation("ABC"));
        String s = "a";
        System.out.println(s.substring(1));
    }
}
