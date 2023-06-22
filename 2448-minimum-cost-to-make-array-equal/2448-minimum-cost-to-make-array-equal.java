class Solution {
    public long minCost(int[] nums, int[] cost) {
      int n = nums.length;
       
       int l = Integer.MAX_VALUE;
       int r = Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
           if(l>nums[i]){
               l=nums[i];
           }
            if(r<nums[i]){
               r=nums[i];
           }
       }
       long ans=0;
       while(l<r){        
           int mid = (l+r)/2;
           long cost1 = helper(nums,cost,mid);
           long cost2= helper(nums,cost,mid+1);
           if(cost1>cost2){
               l=mid+1;
               ans=cost2;
           }
           else{
               r=mid;
               ans=cost1;
           }
       }
       return ans;

    }
    public long helper(int nums[],int cost[],int mid){
        long tc=0L;
        for(int i=0;i<nums.length;i++){
            tc+=1L*Math.abs(nums[i]-mid)*cost[i];
        }
        return tc;   
    }
}