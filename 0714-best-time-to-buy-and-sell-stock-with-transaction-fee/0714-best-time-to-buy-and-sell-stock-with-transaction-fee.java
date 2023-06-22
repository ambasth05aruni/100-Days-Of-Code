class Solution {
    public int maxProfit(int[] prices, int fee) {
          int n = prices.length;
        int profit = 0;
        int buyprice = prices[0];

        for(int i =1 ; i<n; i++){
           profit= Math.max(profit, prices[i]-buyprice-fee);
           buyprice = Math.min(buyprice, prices[i]-profit);
        }
        return profit;
    }
}