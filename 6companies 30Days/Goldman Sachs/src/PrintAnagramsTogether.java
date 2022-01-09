import java.util.*;

public class PrintAnagramsTogether {

    public static List<List<String>> Anagrams(String[] string_list) {
        HashMap<String,ArrayList<String>> bucket = new HashMap<>();
        for(int i=0;i<string_list.length;i++){
            char[] c = string_list[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(bucket.get(s) != null){
                ArrayList<String> temp = bucket.get(s);
                temp.add(string_list[i]);
                bucket.put(s,temp);
            }else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(string_list[i]);
                bucket.put(s,temp);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(ArrayList<String> s : bucket.values()){
            ans.add(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int n = sc.nextInt();
        sc.nextLine();
        String[] string_list = new String[n];
        for(int i=0;i<n;i++){
            string_list[i] = sc.nextLine();
        }
        List<List<String>> ans = Anagrams(string_list);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
