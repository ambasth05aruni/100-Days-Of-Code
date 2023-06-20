class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];

        if(2*k>=n){
            Arrays.fill(ans,-1);
            return ans;
        }

        for(int i=0;i<k;i++){
            ans[i] = -1;
        }

        for(int i=n-1;i>=n-k;i--){
            ans[i] = -1;
        }

        double sum = 0;

        for(int i=0;i<=2*k;i++){
            sum +=nums[i];
        }

        for(int i=k;i<n-k;i++){
            double avg = sum/(2*k+1);
            ans[i] = (int)avg;

            if(i+k+1<n)
                sum = sum - nums[i-k] + nums[i+k+1];
        }

        return ans;
 
    }
}