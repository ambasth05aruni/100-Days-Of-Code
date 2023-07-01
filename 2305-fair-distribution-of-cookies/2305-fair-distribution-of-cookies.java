class Solution {
     int maxval=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
         backtrack(cookies,0,new int[k],k);
        return maxval;
    }
      public void backtrack(int[] cookies,int i,int[] arr,int k){
        if(i==cookies.length){
            int temp=Integer.MIN_VALUE;
            for(int j=0;j<k;j++){
                temp=Math.max(temp,arr[j]);
            }
            maxval=Math.min(maxval,temp);
            return;
        }
        for(int j=0;j<k;j++){
            arr[j]+=cookies[i];
            backtrack(cookies,i+1,arr,k);
            arr[j]-=cookies[i];
        }
      }
}