package com.company;

public class MinimumCostPath {
    private static int minimumCostPath(int[][] arr,int si,int sj){
        if(si==arr.length-1 && sj==arr[0].length-1){
            return arr[si][sj];
        }
        if(si >= arr.length || sj >= arr[0].length){
            return Integer.MAX_VALUE;
        }
        int option1 = minimumCostPath(arr,si,sj+1);
        int option2 = minimumCostPath(arr,si+1,sj+1);
        int option3 = minimumCostPath(arr,si+1,sj);

        return arr[si][sj] + Math.min(option1,Math.min(option2,option3));
    }

    public static int minimumCostPath(int[][] arr){
        return minimumCostPath(arr,0,0);
    }

    private static int minimumCostPathM(int[][] arr,int si,int sj,int[][] dp){
        int m = arr.length;
        int n = arr[0].length;
        if(si >= m || sj >= n){
            return Integer.MAX_VALUE;
        }
        if(si==m-1 && sj==n-1 ){
            dp[si][sj] = arr[si][sj];
            return dp[si][sj];
        }
        if(dp[si][sj] != -1){
            return dp[si][sj];
        }
        int option1 = minimumCostPathM(arr,si,sj+1,dp);
        int option2 = minimumCostPathM(arr,si+1,sj+1,dp);
        int option3 = minimumCostPathM(arr,si+1,sj,dp);

        dp[si][sj] = arr[si][sj] + Math.min(option1,Math.min(option2,option3));
        return dp[si][sj];
    }

    public static int minimumCostPathM(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return minimumCostPathM(arr,0,0,dp);
    }

    private static int minimumCostPathDP(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m][n];
        for(int k=m-1;k>=0;k--){
            for (int l=n-1;l>=0;l--){
                if (k == m-1 && l==n-1){
                    dp[k][l] = arr[k][l];
                }
                else if(k == m-1){
                    dp[k][l] = arr[k][l] + dp[k][l+1];
                }
                else if (l == n-1){
                    dp[k][l] = arr[k][l] + dp[k+1][l];
                }
                else {
                    dp[k][l] = arr[k][l] + Math.min(dp[k+1][l],Math.min(dp[k+1][l+1],dp[k][l+1]));
                }
            }
        }
        
        return dp[0][0];
    }

    public static void main(String[] args) {
        int arr[][] = {{1,1,1},
                       {4,5,2},
                       {7,8,9}};
        System.out.println(minimumCostPathDP(arr));
        System.out.println(minimumCostPathM(arr));
        System.out.println(minimumCostPath(arr));

    }
}
