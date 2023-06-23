class Solution {
    public int longestArithSeqLength(int[] nums) {
         int n = nums.length;
        int[][] dp = new int[n][1001];
        int ans = 1;
        
        for (int i = 1; i < n; i++)
        for (int j = 0; j < i; j++)
        ans = Math.max(ans, dp[i][nums[i] - nums[j] + 500] = dp[j][nums[i] - nums[j] + 500] + 1);
        
        return ans + 1; 
    }
}