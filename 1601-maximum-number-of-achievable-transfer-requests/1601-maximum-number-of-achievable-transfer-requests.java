class Solution {
     public int solve(int i, int N, int n, int[][] req, int[] net){
        if(i==N){
            for(int e: net){
                if(e!=0) return Integer.MIN_VALUE;
            }
            return 0;
        }
        int u=req[i][0];
        int v=req[i][1];
        net[v]++;
        net[u]--;
        int pick=1+solve(i+1, N, n, req, net);
        net[v]--;
        net[u]++;
        int notpick=solve(i+1, N, n, req, net);

        return Math.max(pick, notpick);
    }

    public int maximumRequests(int n, int[][] requests) {
         int[] net=new int[n];
        int N=requests.length;
        return solve(0, N, n, requests, net);
    }
}