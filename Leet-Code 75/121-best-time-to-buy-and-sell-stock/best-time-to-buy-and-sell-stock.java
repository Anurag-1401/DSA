class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE,profit=0,max_profit=0;

        for(int i=0;i<prices.length;i++){
            min_price = Math.min(min_price,prices[i]);
            profit = prices[i] - min_price;
            max_profit = Math.max(profit,max_profit);
        }
        return max_profit;
    }
}