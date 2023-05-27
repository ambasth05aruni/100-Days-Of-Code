class Solution {
    private int dp[];
    public String stoneGameIII(int[] stoneValue) {
       dp = new int[stoneValue.length];
        Arrays.fill(dp,-1);
        int alice = stoneGameIIIMemo(stoneValue,0);
        if(alice < 0) return "Bob";
        if(alice > 0) return "Alice";
        return "Tie";
        
        
    }
	
	private int stoneGameIIIMemo(int[] stoneValue, int start){
        
        if(start >= stoneValue.length){
            return 0;
        }
        if(dp[start] != -1){
            return dp[start];
        }
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, stoneValue[start] - stoneGameIIIMemo(stoneValue, start + 1));
        if(start + 1 < stoneValue.length){
            ans = Math.max(ans, stoneValue[start] + stoneValue[start + 1] - stoneGameIIIMemo(stoneValue, start  + 2));
        }
        if(start + 2 < stoneValue.length){
            ans = Math.max(ans, stoneValue[start] + stoneValue[start + 1] + stoneValue[start + 2] - stoneGameIIIMemo(stoneValue, start + 3));
        }
        return dp[start] = ans;   
    }
}