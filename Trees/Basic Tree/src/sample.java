
import java.io.*;
import java.util.*;

class TreeNode {

    public int data;
    public ArrayList<TreeNode> children;

    public TreeNode(int data) {
        this.data = data;
        children = new ArrayList<>();
    }
}

public class sample {

    static int a;

    public static TreeNode takeInput(TreeNode root,int x,int y){
        TreeNode parent = find(root,x,a);
        TreeNode newNode = new TreeNode(y);
        if(parent != null){
            parent.children.add(newNode);
            return parent;
        }
        return newNode;
    }

    public static TreeNode find(TreeNode head,Integer x,int a){
        if(head == null){
            return null;
        }
        if(head.data == x){
            return head;
        }
        a++;
        for(TreeNode n: head.children){
            TreeNode res = find(n,x,a);
            if(res!=null){
                return res;
            }
        }
        return null;
    }

    public static int distance(TreeNode head,int x,int y){
        TreeNode xNode = find(head,x,a);
        TreeNode yNode = find(xNode,y,0);
        return a;
    }

    public static void main(String args[] ) throws Exception {
        int N,H;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        H = scanner.nextInt();
        scanner.nextLine();
        int[] h = new int[H];
        for(int i = 0;i < H ; i++){
            h[i] = scanner.nextInt();
        }
        scanner.nextLine();
        TreeNode head = null;
        for(int i=0;i<N-1;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();
            head = takeInput(head,x,y);
        }
        System.out.println(distance(head,2,4));
    }

}

